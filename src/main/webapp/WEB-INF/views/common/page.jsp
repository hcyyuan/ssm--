<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div style="text-align: center;">
    <ul id="pagination" class="pagination"></ul>
</div>
<script>
    //分页
    //数据集data  总条数totalCount   总页数totalPage   上一页prevPage  下一页nextPage
    //当前页currentPage   每页显示的数据量pageSize
    $(function(){
        $("#pagination").twbsPagination({
            totalPages: ${pageResult.totalPage} || 1,
            startPage: ${pageResult.currentPage} || 1,
            visiblePages:5,
            first:"首页",
            prev:"上页",
            next:"下页",
            last:"尾页",
            initiateStartPageClick:false,
            onPageClick:function(event,page){
            $("#currentPage").val(page);
            $("#searchForm").submit();
        }
    });
    })
</script>
</html>