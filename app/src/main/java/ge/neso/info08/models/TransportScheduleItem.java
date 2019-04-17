package ge.neso.info08.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransportScheduleItem {


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class schedule {

        @JsonProperty("pt_id")
        private String ptId;

        @JsonProperty("dir_num")
        private String dirNum;

        @JsonProperty("dir_old_num")
        private String dirOldNum;

        @JsonProperty("cycled_id")
        private Integer cycledId;

        @JsonProperty("service_id")
        private Integer serviceId;

        @JsonProperty("remark_type")
        private Integer remarkType;


        private String price;

        @JsonProperty("has_dir_list")
        private Integer hasDirList;

        private String remark;

        @JsonProperty("start_station")
        private String startStation;

        @JsonProperty("end_station")
        private String endStation;


        public String getPtId() {
            return ptId;
        }

        public void setPtId(String ptId) {
            this.ptId = ptId;
        }

        public String getDirNum() {
            return dirNum;
        }

        public void setDirNum(String dirNum) {
            this.dirNum = dirNum;
        }

        public String getDirOldNum() {
            return dirOldNum;
        }

        public void setDirOldNum(String dirOldNum) {
            this.dirOldNum = dirOldNum;
        }

        public Integer getCycledId() {
            return cycledId;
        }

        public void setCycledId(Integer cycledId) {
            this.cycledId = cycledId;
        }

        public Integer getServiceId() {
            return serviceId;
        }

        public void setServiceId(Integer serviceId) {
            this.serviceId = serviceId;
        }

        public Integer getRemarkType() {
            return remarkType;
        }

        public void setRemarkType(Integer remarkType) {
            this.remarkType = remarkType;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public Integer getHasDirList() {
            return hasDirList;
        }

        public void setHasDirList(Integer hasDirList) {
            this.hasDirList = hasDirList;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getStartStation() {
            return startStation;
        }

        public void setStartStation(String startStation) {
            this.startStation = startStation;
        }

        public String getEndStation() {
            return endStation;
        }

        public void setEndStation(String endStation) {
            this.endStation = endStation;
        }
    }


    @JsonProperty("current_page")
    private String currentPage;

    private List<schedule> data;

    @JsonProperty("first_page_url")
    private String firstPageUrl;

    private Integer from;

    @JsonProperty("last_page")
    private Integer lastPage;

    @JsonProperty("last_page_url")
    private String lastPageUrl;

    @JsonProperty("next_page_url")
    private String nextPageUrl;

    private String path;

    @JsonProperty("per_page")
    private Integer perPage;

    @JsonProperty("prev_page_url")
    private String prevPageUrl;

    private Integer to;

    private Integer total;


    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public List<schedule> getData() {
        return data;
    }

    public void setData(List<schedule> data) {
        this.data = data;
    }

    public String getFirstPageUrl() {
        return firstPageUrl;
    }

    public void setFirstPageUrl(String firstPageUrl) {
        this.firstPageUrl = firstPageUrl;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public String getLastPageUrl() {
        return lastPageUrl;
    }

    public void setLastPageUrl(String lastPageUrl) {
        this.lastPageUrl = lastPageUrl;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public String getPrevPageUrl() {
        return prevPageUrl;
    }

    public void setPrevPageUrl(String prevPageUrl) {
        this.prevPageUrl = prevPageUrl;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
