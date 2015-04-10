$( document )
	.ready( function () {
		var i = 0;
		$( "input[name=username]" )
			.blur( function () {
				if ( this.value == "" ) {
					alert( "请填写姓名！" );
				}

			} );
		$( "input[name=email]" )
			.focus( function () {
				//		   $("#email").text("请输入正确的EMAIL格式");
			} );
		$( "input[name=email]" )
			.blur( function () {
				if ( this.value == "" || ( this.value != "" && !/.+@.+\.[a-zA-Z]{2,4}$/.test( this.value ) ) ) {
					$( "#email" )
						.text( "请重新输入邮箱！" );
					i++;
				} else {
					$( "#email" )
						.text( "输入格式正确！" );

				}

			} );
		$( "input[name=xuehao]" )
			.focus( function () {
				$( "#studentID" )
					.text( "" );
			} );
		//
		$( "input[name=xuehao]" )
			.blur( function () {
				if ( $( this )
					.val()
					.length == 12 && $( this )
					.val() != '' && /201/.test( this.value ) ) {
					$( "#studentID" )
						.text( "输入正确！" );

				} else {
					$( "#studentID" )
						.html( "输入<span style='color:red;'>错误</span>！" );
					this.value = "";
					i++;
				}


			} );
		$( "input[name=password]" )
			.blur( function () {
				if ( $( this )
					.val()
					.length >= 6 && $( this )
					.val()
					.length <= 12 && $( this )
					.val() != '' ) {
					$( "#password" )
						.text( "密码格式输入正确！" );

				} else {
					$( "#password" )
						.html( "密码格式输入<span style='color:red;'>错误</span>！" );
					this.value = "";
					i++;
				}


			} );

		$( "#img" )
			.click( function () {
				if ( i > 0 ) {
					i = 0;
					alert( "拒绝提交,请重新输入！" );
					return false;
				}



			} );

	} );