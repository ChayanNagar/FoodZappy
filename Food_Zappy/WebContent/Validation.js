function valid()
{
  //username validation
   	
 	var correct_way=/^[a-zA-Z\-]+$/;
  	var a=document.getElementById("Cname").value;
  	
  	if(a=="")
	{
		alert('Pls fill name');
		document.getElementById("message")
		return false;
	}
	if(a.length>20)
	{   alert('Length of name should be less than 20')
		document.getElementById("message")
		return false;
	}
	 if(!a.match(correct_way))
	{  
		alert('*only alphabelts are alloweds')
	  	document.getElementById("message")
	  return false;
	  }
		//email validation
		var b=document.getElementById("emailid").value;
     if(b=="")
	   {
	   	alert('Fill our email id')
		document.getElementById("msg")
		return false;
		}
		if(b.indexOf('@')==0)
		{  alert('*Invalid position of @ ')

			document.getElementById("msg")
		    return false;
		}
		if( b.charAt(b.length-4)!='.'  &&  b.charAt(b.length-3)!='.' )
		{   alert("*Invalid character after '.' ")

			document.getElementById("msg")
		    return false;
		} 
		

		//password validation
		var password=document.getElementById("pwd").value;
    	
    	if(password=="" )
    	{ alert('* Pls fill password')
    		document.getElementById("message2").focus();
    		return false;
    	}

    if(password<5 || password>10)
    {  alert('* except between 5-10 character')
      	document.getElementById("message2")
    		return false;

    }

   //mobile no validation
		var c=document.getElementById("mobileno").value;
		if(c=="")
		{    alert('Pls fill mobile no')
			document.getElementById("message3")
			return false;
		}
		
	 	if(c.length>10 || c.length<10)
	 	{    alert('Mobile no should be 10 digit')
	 		document.getElementById("message3")
			return false;
        }
        if(c.charAt(0)!=9 && c.charAt(0)!=8 && c.charAt(0)!=7)
        {   alert('Mobile no should start with 9,8,7 only')
        	document.getElementById("message3")
			return false;
        }
	 //return true;
      //address validation
        var a=document.getElementById("address").value;
      	
      	if(a=="")
    	{
    		alert('Pls fill address');
    		document.getElementById("message4")
    		return false;
    	}

   
    //alert("end")
        //return true;
    }

	 