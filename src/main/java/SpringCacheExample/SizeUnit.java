package SpringCacheExample;

import java.io.Serializable;

public class SizeUnit implements Serializable {
    private Integer id;
    private String sizeUnit;
    private String type;

    public SizeUnit(Integer id, String sizeUnit, String type) {
        this.id = id;
        this.sizeUnit = sizeUnit;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getSizeUnit() {
        return sizeUnit;
    }

    public String getType() {
        return type;
    }
}
