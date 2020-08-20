/*
 * package com.song.shop.service.oauth2;
 * 
 * import java.util.Collections;
 * 
 * import javax.servlet.http.HttpSession;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
 * import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
 * import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
 * import
 * org.springframework.security.oauth2.core.OAuth2AuthenticationException;
 * import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
 * import org.springframework.security.oauth2.core.user.OAuth2User; import
 * org.springframework.stereotype.Service;
 * 
 * import com.song.shop.dto.Oauth2Attributes; import com.song.shop.entity.User;
 * import com.song.shop.repository.Oauth2UserRepository; import
 * com.song.shop.utils.SessionUser;
 * 
 * @Service public class CustomOAuth2UserService implements
 * OAuth2UserService<OAuth2UserRequest, OAuth2User> {
 * 
 * @Autowired private Oauth2UserRepository oauth2UserRepository;
 * 
 * private HttpSession httpSession;
 * 
 * @Override public OAuth2User loadUser( OAuth2UserRequest userRequest ) throws
 * OAuth2AuthenticationException { OAuth2UserService<OAuth2UserRequest,
 * OAuth2User> delegate = new DefaultOAuth2UserService();
 * 
 * OAuth2User oAuth2User = delegate.loadUser( userRequest );
 * 
 * // 현재 로그인 진행 중인 서비스를 구분하는 코드 String registrationId = userRequest
 * .getClientRegistration() .getRegistrationId();
 * 
 * // oauth2 로그인 진행 시 키가 되는 필드 값 String userNameAttributeName =
 * userRequest.getClientRegistration() .getProviderDetails()
 * .getUserInfoEndpoint() .getUserNameAttributeName();
 * 
 * // OAuthAttributes : attribute 를 담을 클래스 Oauth2Attributes attributes =
 * Oauth2Attributes.of( registrationId, userNameAttributeName,
 * oAuth2User.getAttributes() );
 * 
 * User user = saveOrUpdate( attributes );
 * 
 * httpSession.setAttribute("oauth2_user", new SessionUser( user ) );
 * 
 * return new DefaultOAuth2User( Collections.singleton( new
 * SimpleGrantedAuthority( "ROLE_CUSTOMER" ) ), attributes.getAttributes() ,
 * attributes.getNameAttributeKey() ); }
 * 
 * private User saveOrUpdate( Oauth2Attributes attributes ) {
 * 
 * // User user = oauth2UserRepository.findById( attributes.getEmail() ) //
 * .map( entity -> entity.update( attributes.getEmail(), attributes.getPicture()
 * ) ) // .orElse( attributes.toEntity() );
 * 
 * return oauth2UserRepository.save( oauth2UserRepository.findById(
 * attributes.getEmail() ) .map( entity -> entity.update( attributes.getEmail(),
 * attributes.getPicture() ) ) .orElse( attributes.toEntity() ) ); }
 * 
 * }
 */