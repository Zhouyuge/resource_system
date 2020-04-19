package com.bishe.main;

import java.util.List;
import java.util.Map;

/**
 * @author Kirito
 * @Date 2020/4/18 10:00
 */
public class Res {
    private Integer total;
    private Integer page ;
    private Integer pageSize;
    private List<Map<String, Object>> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<Map<String, Object>> getRows() {
        return rows;
    }

    public void setRows(List<Map<String, Object>> rows) {
        this.rows = rows;
    }
}
