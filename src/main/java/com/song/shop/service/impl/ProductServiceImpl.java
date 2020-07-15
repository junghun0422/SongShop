package com.song.shop.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.song.shop.dto.ProductDto;
import com.song.shop.entity.CategoryEntity;
import com.song.shop.entity.ProductEntity;
import com.song.shop.mapper.Category_Product_Mapper;
import com.song.shop.repository.CategoryRepository;
import com.song.shop.repository.ProductRepository;
import com.song.shop.repository.querydsl.ProductRepositorySupport;
import com.song.shop.service.ProductService;
import com.song.shop.utils.Constant;
import com.song.shop.utils.CyResult;

@Service
public class ProductServiceImpl implements ProductService
{
	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductRepositorySupport productRepositorySupport;
	
	@Autowired
	private Category_Product_Mapper categoryProductMapper;

	@Override
	public CyResult<String> registProduct(Authentication auth, HttpServletRequest request, HttpServletResponse response, ProductDto productDto, MultipartFile product_img) 
	{
		CyResult<String> result = new CyResult<>();
		
		if(StringUtils.isEmpty(productDto.getCategory_code()) || StringUtils.isEmpty(productDto.getProduct_nm()) ||
				StringUtils.isEmpty(productDto.getProduct_price()) || product_img.getSize() < 1)
		{
			result.setCode(Constant.RESULT_FAIL_CODE_01);
			result.setMessage("필수항목이 누락되었습니다.");
			return result;
		}
		
		String fileName = product_img.getOriginalFilename();
		String uploadPath = request.getServletContext().getRealPath("/upload/proudct");
		
		String[] arr = fileName.split("\\.");
		String name = arr[0] + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "." + arr[1];
		
		File file = new File(uploadPath + "/" + auth.getName() + "/" + name);
		
		log.debug("###########################################");
		log.debug("filePath :: " + file.getAbsolutePath());
		log.debug("###########################################");
		
		try
		{
			FileUtils.writeByteArrayToFile(file, product_img.getBytes());
			
			// DataBase 작업 필요
			ProductEntity entity = new ProductEntity();
			entity.setCategory(new CategoryEntity(Integer.parseInt(productDto.getCategory_code()), productDto.getCategory_nm()));
			entity.setProduct_nm(productDto.getProduct_nm());
			entity.setProduct_price(productDto.getProduct_price());
			entity.setProduct_img_path(file.getAbsolutePath());
			entity.setProduct_des(productDto.getProduct_des());
			entity.setRegister_id(auth.getName());
			
			productRepository.save(entity);
			
			result.setCode(Constant.RESULT_SUCCESS_CODE);
			result.setMessage("상품 등록 성공");
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			result.setCode(Constant.RESULT_FILE_CODE_90);
			result.setMessage("상품 이미지 업로드 실패");
		}
		
		return result;
	}

	@Override
	public CyResult<List<CategoryEntity>> searchCategoryList() 
	{
		CyResult<List<CategoryEntity>> result = new CyResult<>();;
				
		List<CategoryEntity> list = categoryRepository.findAll();
		
		if(list.size() < 1)
		{
			result.setCode(Constant.RESULT_FAIL_CODE_02);
			result.setMessage("조회된 결과가 없습니다.");
			return result;
		}
		
		result.setCode(Constant.RESULT_SUCCESS_CODE);
		result.setMessage("데이터 조회 성공");
		result.setData(list);
		
		return result;
	}

	@Override
	public CyResult<List<ProductDto>> searchProductListByRegisterId(String registerId) 
	{
		CyResult<List<ProductDto>> result = new CyResult<>();
		
		if( StringUtils.isEmpty( registerId ) )
		{
			result.setCode(Constant.RESULT_FAIL_CODE_01);
			result.setMessage("필수항목이 누락되었습니다.");
			return result;
		}

//		List<ProductEntity> productList = productRepositorySupport.findByRegisterId( registerId );
		
		List<ProductDto> productList = categoryProductMapper.searchProductListByRegisterId(registerId);
		
		if( productList.size() < 1 )
		{
			result.setCode(Constant.RESULT_FAIL_CODE_02);
			result.setMessage("조회된 결과가 존재하지 않습니다.");
			return result;
		}
			
		result.setCode(Constant.RESULT_SUCCESS_CODE);
		result.setMessage("상품 목록 조회 성공");
		result.setData(productList);
		
		return result;
	}
	
}
