package niit.wei.dto;

/**
 * @Author WeiJinLong
 * @Date 2023-06-29 17:06
 * @Version 1.0
 */
public class Page {
    private Integer pageNo;//当前页码
    private Integer pageSize;//每页显示多少条数
    private Integer pageCount;//数据库总页数
    private Long count;//数据库表总记录数
    private Boolean hasNextPage;//是否有下一页
    private Boolean hasPrePage;//是否有上一页
    private Object page;//当前页数据


    public Page() {
    }

    public Page(Integer pageNo, Integer pageSize, Integer pageCount, Long count, Boolean hasNextPage, Boolean hasPrePage, Object page) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.count = count;
        this.hasNextPage = hasNextPage;
        this.hasPrePage = hasPrePage;
        this.page = page;
    }

    /**
     * 获取
     * @return pageNo
     */
    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * 设置
     * @param pageNo
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 获取
     * @return pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置
     * @param pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取
     * @return pageCount
     */
    public Integer getPageCount() {
        return pageCount;
    }

    /**
     * 设置
     * @param pageCount
     */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * 获取
     * @return count
     */
    public Long getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(Long count) {
        this.count = count;
    }

    /**
     * 获取
     * @return hasNextPage
     */
    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    /**
     * 设置
     * @param hasNextPage
     */
    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    /**
     * 获取
     * @return hasPrePage
     */
    public Boolean getHasPrePage() {
        return hasPrePage;
    }

    /**
     * 设置
     * @param hasPrePage
     */
    public void setHasPrePage(Boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }

    /**
     * 获取
     * @return page
     */
    public Object getPage() {
        return page;
    }

    /**
     * 设置
     * @param page
     */
    public void setPage(Object page) {
        this.page = page;
    }

    public String toString() {
        return "Page{pageNo = " + pageNo + ", pageSize = " + pageSize + ", pageCount = " + pageCount + ", count = " + count + ", hasNextPage = " + hasNextPage + ", hasPrePage = " + hasPrePage + ", page = " + page + "}";
    }
}
