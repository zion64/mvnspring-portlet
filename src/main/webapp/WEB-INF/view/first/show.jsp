<%@page session="false" contentType="text/html" pageEncoding="UTF-8" import="java.util.*,javax.portlet.*"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<portlet:defineObjects />

<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
 
<liferay-portlet:resourceURL var="sampleUrl" />
 
<input type="button" value="Ajax Call" onclick="ajaxMethod('${sampleUrl}');" />
 
 
<script>
 
function ajaxMethod(sampleUrl){
		
		$.ajax({
			type: 'GET',
			url:  sampleUrl,
			cache:false,
			async:true,
			error: function(){
						alert('error');
				   },		
			dataType : "html",
			data :{
				name:"hello123"
				},
			success: function(htmlData) {			
				alert('response : ' + htmlData);
			},
			complete: function(){
			}
		});
}
 
</script>