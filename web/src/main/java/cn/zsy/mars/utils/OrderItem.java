package cn.zsy.mars.utils;


/**
 * 排序控制
 *
 */
public class OrderItem implements java.io.Serializable {

    private static final long serialVersionUID = 4591350900914780041L;
    //列名（对应实体的属性命名规范）
    String columnName;
    //排序方式
    OrderOption option = OrderOption.DESC;

    public String getColumnName() {
        return columnName;
    }

    public String getType() {
        return option.getType();
    }

    public OrderItem(String columnName, OrderOption option) {
        this.columnName = columnName;
        this.option = option;
    }

    /**
     * 排序类型
     *
     */
    public enum OrderOption {
        ASC("ASC"),
        DESC("DESC");
        String type;

        OrderOption(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}

