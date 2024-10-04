<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="${pageContext.request.contextPath}/admin/category/update" method="post" enctype="multipart/form-data">  <!-- Cách viết JSP, có cách JSTL nữa -->
  
  <input type="text" name="categoryid" hidden="hidden" ${cate.categoryname}">
  <label for="fname">Category name:</label><br>
  <input type="text" id="categoryname" name="${cate.categoryname}"><br>
  <label for="lname">Link images:</label><br>
  <input type="text" id="images" name="images" value = "${cate.images}" > <br>
  
  <label for="lname">Upload file:</label><br>
  <input type="file" id="images1" name="images1" value = "${cate.images}"> <br>
  
  
  
  <label for="lname">Status:</label><br>
  <input type="radio" id="ston" name="status" value="1" ${cate.status==1?'checked':'' }>
  <label for="css">Hoạt động</label><br>
  <input type="radio" id="stoff" name="status" value="0" ${cate.status!=1?'checked':'' }>
  <label for="javascript">Khóa</label><br>
  <hr>
  <input type="submit" value="Insert"><br>
</form>