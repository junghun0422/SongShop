<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TREE</title>
<style>
html,body
{
	height	:	100%;
}

input
{
	width	:	120px !important;
}
#wrap
{
	width	:	100%;
	height	:	100%;
	display	:	flex;
}
</style>
<link rel="stylesheet" href="lib/jqwidgets/styles/jqx.base.css" type="text/css" />
<script type="text/javascript" src="lib/scripts/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="lib/jqwidgets/jqxcore.js"></script>
<script type="text/javascript" src="lib/jqwidgets/jqxdata.js"></script>
<script type="text/javascript" src="lib/jqwidgets/jqxdatatable.js"></script>

<script type="text/javascript" src="lib/jqwidgets/jqxtree.js"></script>
<script type="text/javascript" src="lib/jqwidgets/jqxtreegrid.js"></script>

<script type="text/javascript" src="lib/jqwidgets/jqxscrollbar.js"></script>
<script type="text/javascript" src="lib/jqwidgets/jqxbuttons.js"></script>
<script type="text/javascript" src="lib/jqwidgets/jqxdropdownlist.js"></script>
<script type="text/javascript" src="lib/jqwidgets/jqxlistbox.js"></script>

</head>
<body>
<div id="wrap">
	<div id="jqxTree"></div>
	<div id="jqxWithTree"></div>
</div>
<script type="text/javascript">
	$(document).ready(function() 
	{
      var adapter = new $.jqx.dataAdapter(
		{
			datatype	:	"json",
			url			:	"/getGroupList",
			dataFields	:	[
                { name: 'groupSeq', type: 'string' },
                { name: 'pGroupSeq', type: 'string' },
                { name: 'groupNm', type: 'string' },
                { name: 'dispOrdr', type: 'string' }
			],
			hierarchy	:	{
				keyDataField	:	{ name	:	"groupSeq" },
				parentDataField	:	{ name	:	"pGroupSeq" }
			},
			id			:	"groupSeq"
		});
		
		$("#jqxTree").jqxTreeGrid({
			source			:	adapter,
			width			:	"9%",
			height			:	"99.8%",
            altRows 		:	false,
            filterable		:	true,
            autoRowHeight	:	false,
            pageable		:	false,
            showHeader		:	false,
           	ready			:	function()
           	{
				$("#jqxTree").jqxTreeGrid("expandAll");
			},
            selectionMode	:	'singleRow',
			columns			:	[
								{ text	:	"명칭" , dataField	:	"groupNm" }
							]			
		});


       var _adapter = new $.jqx.dataAdapter(
		{
			datatype	:	"json",
			url			:	"/getGroupParkList",
			data		:	{ "deptTy" : "G_1"},
			dataFields	:	[
                { name: 'group_seq', type: 'string' },
                { name: 'p_group_seq', type: 'string' },
                { name: 'group_nm', type: 'string' },
                { name: 'disp_ordr', type: 'string' }
			],
			hierarchy	:	{
				keyDataField	:	{ name	:	"group_seq" },
				parentDataField	:	{ name	:	"p_group_seq" }
			},
			id			:	"group_seq"
		});

		$("#jqxWithTree").jqxTreeGrid({
			source			:	_adapter,
			width			:	"9%",
			height			:	"99.8%",
            altRows 		:	false,
            filterable		:	true,
            autoRowHeight	:	false,
            pageable		:	false,
            showHeader		:	false,
           	ready			:	function()
           	{
				$("#jqxWithTree").jqxTreeGrid("expandAll");
			},
            selectionMode	:	'singleRow',
			columns			:	[
								{ text	:	"명칭" , dataField	:	"group_nm" }
							]			
		});
	});	
</script>

</body>
</html>