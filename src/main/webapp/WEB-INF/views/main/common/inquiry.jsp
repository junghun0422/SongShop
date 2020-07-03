<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="https://cdn.ckeditor.com/ckeditor5/19.1.1/classic/ckeditor.js"></script>
<!-- <script src="https://cdn.ckeditor.com/ckeditor5/19.1.1/decoupled-document/ckeditor.js"></script> -->
<!-- <script src="https://cdn.ckeditor.com/ckeditor5/19.1.1/inline/ckeditor.js"></script>  -->
<!-- <script src="https://cdn.ckeditor.com/ckeditor5/19.1.1/balloon/ckeditor.js"></script> -->
<style>
	html, body
	{
		width	:	100%;
		height	:	100%;
	}
	
	.container
	{
		position			:	absolute;
		top					:	50%;
		left				:	50%;
		margin				:	auto;
		transform			:	translateX(-50%) translateY(-50%);
		-moz-transform		:	translateX(-50%) translateY(-50%);  
		-webkit-transform	:	translateX(-50%) translateY(-50%);  
		-o-transform		:	translateX(-50%) translateY(-50%);
		-ms-transform		:	translateX(-50%) translateY(-50%);
	}
	
	.input-group { left	: 25%; }
</style>
<body>
	<div class="container">
		<div class="input-group">
			<textarea id="editor" style="margin-top:500px;"></textarea>
		</div>
		<div>
			<button class="btn btn-default">저장</button>
		</div>
	</div>
</body>

<script type="text/javascript">
	var name = '${_csrf.headerName}';
	var token = '${_csrf.token}';

	var data;
	/* CKEDITOR.replace("p_content", {
		 width	:	500, height	:	500,
		 filebrowserUploadUrl	:	"/inquiry/imgUpload?_csrf=" + token
		 }); */
	$(".btn").click(function() 
	{
		console.log(data.getData());
	});

	class MyUploadAdapter
	{
		constructor( loader )
		{
			this.loader = loader;
		}

		upload()
		{
			return this.loader.file
				.then( file => new Promise( ( resolve, reject ) => 
				{
					this._initRequest();
					this._initListeners( resolve, reject, file );
					this._sendRequest( file );
				}));
		}

		abort()
		{
			if( this.xhr )
			{
				this.xhr.abort();
			}
		}

		_initRequest()
		{
			const xhr = this.xhr = new XMLHttpRequest();
			xhr.open("POST", "/inquiry/imgUpload", true);
			xhr.setRequestHeader(name, token);
			xhr.responseType = "json";
		}

		_initListeners( resolve, reject, file )
		{
			const xhr = this.xhr;
			const loader = this.loader;
			const genericErrorText = "Couldn't upload file : " + ${file.name} + ".";

			xhr.addEventListener( "error", () => reject ( genericErrorText ) );
			xhr.addEventListener( "abort", () => reject() );
			xhr.addEventListener( "load", () => {
				const response = xhr.response;

				if( !response || response.error )
				{
					return reject( response && response.error ? response.error.message : genericErrorText );
				}

				resolve( {
					default	: response.url
				});
			});

			if( xhr.upload )
			{
				xhr.upload.addEventListener( "progress", evt => 
				{
					if( evt.lengthComputable )
					{
						loader.uploadTotal = evt.total;
						loader.uploaded = evt.uploaded;
					}
				})
			} 
		}

		_sendRequest( file )
		{
			const data = new FormData();

			data.append( "upload", file );

			this.xhr.send( data );
		}
	}

	function MyCustomUploadAdapterPlugin( editor )
	{
		editor.plugins.get( "FileRepository" ).createUploadAdapter = ( loader ) => {
			return new MyUploadAdapter( loader );
		}
	}


	ClassicEditor
		.create( document.querySelector( "#editor" ),
		{
			extraPlugins : [ MyCustomUploadAdapterPlugin ]			
		})
		.then( editor => {
			data = editor;
		})
		.catch( error => {
			console.log(error);
		});	
</script>