/**
 * 
 */

//회원가입 폼 value확인하는 자바스크립트

 function sendit(){
	 		let frm = document.joinForm;
			let idTag = frm.userid;
			let pwTag = frm.userpw;
			let nameTag = frm.username;
			let phoneTag = frm.userphone;
			let checkpwTag = frm.userpw_re;
	 //아이디 "" 체크, alert(), focus()
	 if( idTag.value == "" ){
				alert("아이디를 입력하세요!");
				idTag.focus();
				return false;
			}
	 //아이디 5자 이상, 16자 미만
	 if( idTag.value.length <=4 || idTag.value.length >=16 ){
				alert("아이디는 5자리 이상,16자 미만으로 입력하세요!");
				pwTag.focus();
				return false;
			}
	 //비밀번호 ""체크, alert(),focus()
	  if( pwTag.value == "" ){
				alert("비밀번호를 입력하세요!");
				idTag.focus();
				return false;
			}
	 //비밀번호 8자 이상
	  if(8<pwTag.value.length ){
				alert("비밀번호는 8자 이상 입력하세요!");
				pwTag.focus();
				return false;
			}
	 //비밀번호 == 비밀번호 확인
	  if(pwTag.value == checkpwTag.value ){
				alert("비밀번호 일치");
				pwTag.focus();
				return false;
			}
	 //이름 ""체크, alert(),focus()
	 if( nameTag.value == "" ){
				alert("이름을 입력하세요!");
				idTag.focus();
				return false;
			}
	 //휴대폰 번호 ""체크, alert(),focus()
	 if( phoneTag.value == "" ){
				alert("전화번호를 입력하세요!");
				phoneTag.focus();
				return false;
			}
			
	 //submit
	 frm.submit();
	 
	 //로그인시 validation 처리
	 
	 
 }
 
 function logincheck(){
		 let frm =document.frm;
		 let userid = frm.userid;
		 let userpw = frm.userpw;
		  if( userid.value == "" ){
				alert("아이디를 입력하세요!");
				id.focus();
				return false;
			}
			if( userpw.value == "" ){
				alert("비밀번호를 입력하세요!");
				pw.focus();
				return false;
			}
			frm.submit();
	 }