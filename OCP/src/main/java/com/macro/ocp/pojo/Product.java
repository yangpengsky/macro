package com.macro.ocp.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品表
 * @TableName product
 */
public class Product implements Serializable {
    /**
     * 产品编码
     */
    private Integer productCode;

    /**
     * 产品线
     */
    private String productLine;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品简称
     */
    private String productAbbreviation;

    /**
     * 计量单位编码
     */
    private Integer uomCode;

    /**
     * 计量单位名称
     */
    private String uomName;

    /**
     * 规格
     */
    private String specifications;

    /**
     * 类别编码
     */
    private Integer categoryCode;

    /**
     * 大类名称
     */
    private String categoryName;

    /**
     * 产品型号
     */
    private String productModel;

    /**
     * 售后产品型号
     */
    private String aftersalesModel;

    /**
     * 颜色
     */
    private String productColor;

    /**
     * 条形码
     */
    private String barCode;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;

    /**
     * 提货价
     */
    private BigDecimal pickupPrice;

    /**
     * 开票价
     */
    private BigDecimal ticketPrice;

    /**
     * 标准价
     */
    private BigDecimal standardPrice;

    /**
     * 溢价(按比例)
     */
    private BigDecimal premiumRatio;

    /**
     * 溢价(按额度)
     */
    private BigDecimal premiumLimit;

    /**
     * 生效时间
     */
    private Date effectiveDate;

    /**
     * 失效时间
     */
    private Date expirationTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 修改人
     */
    private String modifyBy;

    /**
     * 销售属性
     */
    private String salesAttributes;

    /**
     * 气种
     */
    private String gasSpecies;

    /**
     * 产品属性
     */
    private String productAttributes;

    /**
     * 体积
     */
    private BigDecimal volume;

    /**
     * 重量
     */
    private BigDecimal weight;

    /**
     * 长度
     */
    private BigDecimal length;

    /**
     * 宽度
     */
    private BigDecimal width;

    /**
     * 高度
     */
    private BigDecimal height;

    /**
     * 是否新品
     */
    private String isnewProduct;

    /**
     * 是否销售
     */
    private String issales;

    /**
     * 是否停产
     */
    private String isstopProduction;

    /**
     * 是否暂停生产
     */
    private String issuspendProduction;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 状态
     */
    private String productStatus;

    /**
     * 出货仓库
     */
    private String shippingWarehouse;

    private static final long serialVersionUID = 1L;

    /**
     * 产品编码
     */
    public Integer getProductCode() {
        return productCode;
    }

    /**
     * 产品编码
     */
    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

    /**
     * 产品线
     */
    public String getProductLine() {
        return productLine;
    }

    /**
     * 产品线
     */
    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    /**
     * 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 产品简称
     */
    public String getProductAbbreviation() {
        return productAbbreviation;
    }

    /**
     * 产品简称
     */
    public void setProductAbbreviation(String productAbbreviation) {
        this.productAbbreviation = productAbbreviation;
    }

    /**
     * 计量单位编码
     */
    public Integer getUomCode() {
        return uomCode;
    }

    /**
     * 计量单位编码
     */
    public void setUomCode(Integer uomCode) {
        this.uomCode = uomCode;
    }

    /**
     * 计量单位名称
     */
    public String getUomName() {
        return uomName;
    }

    /**
     * 计量单位名称
     */
    public void setUomName(String uomName) {
        this.uomName = uomName;
    }

    /**
     * 规格
     */
    public String getSpecifications() {
        return specifications;
    }

    /**
     * 规格
     */
    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    /**
     * 类别编码
     */
    public Integer getCategoryCode() {
        return categoryCode;
    }

    /**
     * 类别编码
     */
    public void setCategoryCode(Integer categoryCode) {
        this.categoryCode = categoryCode;
    }

    /**
     * 大类名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 大类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 产品型号
     */
    public String getProductModel() {
        return productModel;
    }

    /**
     * 产品型号
     */
    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    /**
     * 售后产品型号
     */
    public String getAftersalesModel() {
        return aftersalesModel;
    }

    /**
     * 售后产品型号
     */
    public void setAftersalesModel(String aftersalesModel) {
        this.aftersalesModel = aftersalesModel;
    }

    /**
     * 颜色
     */
    public String getProductColor() {
        return productColor;
    }

    /**
     * 颜色
     */
    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    /**
     * 条形码
     */
    public String getBarCode() {
        return barCode;
    }

    /**
     * 条形码
     */
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    /**
     * 零售价
     */
    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    /**
     * 零售价
     */
    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    /**
     * 提货价
     */
    public BigDecimal getPickupPrice() {
        return pickupPrice;
    }

    /**
     * 提货价
     */
    public void setPickupPrice(BigDecimal pickupPrice) {
        this.pickupPrice = pickupPrice;
    }

    /**
     * 开票价
     */
    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    /**
     * 开票价
     */
    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    /**
     * 标准价
     */
    public BigDecimal getStandardPrice() {
        return standardPrice;
    }

    /**
     * 标准价
     */
    public void setStandardPrice(BigDecimal standardPrice) {
        this.standardPrice = standardPrice;
    }

    /**
     * 溢价(按比例)
     */
    public BigDecimal getPremiumRatio() {
        return premiumRatio;
    }

    /**
     * 溢价(按比例)
     */
    public void setPremiumRatio(BigDecimal premiumRatio) {
        this.premiumRatio = premiumRatio;
    }

    /**
     * 溢价(按额度)
     */
    public BigDecimal getPremiumLimit() {
        return premiumLimit;
    }

    /**
     * 溢价(按额度)
     */
    public void setPremiumLimit(BigDecimal premiumLimit) {
        this.premiumLimit = premiumLimit;
    }

    /**
     * 生效时间
     */
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * 生效时间
     */
    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /**
     * 失效时间
     */
    public Date getExpirationTime() {
        return expirationTime;
    }

    /**
     * 失效时间
     */
    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    /**
     * 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 修改人
     */
    public String getModifyBy() {
        return modifyBy;
    }

    /**
     * 修改人
     */
    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    /**
     * 销售属性
     */
    public String getSalesAttributes() {
        return salesAttributes;
    }

    /**
     * 销售属性
     */
    public void setSalesAttributes(String salesAttributes) {
        this.salesAttributes = salesAttributes;
    }

    /**
     * 气种
     */
    public String getGasSpecies() {
        return gasSpecies;
    }

    /**
     * 气种
     */
    public void setGasSpecies(String gasSpecies) {
        this.gasSpecies = gasSpecies;
    }

    /**
     * 产品属性
     */
    public String getProductAttributes() {
        return productAttributes;
    }

    /**
     * 产品属性
     */
    public void setProductAttributes(String productAttributes) {
        this.productAttributes = productAttributes;
    }

    /**
     * 体积
     */
    public BigDecimal getVolume() {
        return volume;
    }

    /**
     * 体积
     */
    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    /**
     * 重量
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * 重量
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * 长度
     */
    public BigDecimal getLength() {
        return length;
    }

    /**
     * 长度
     */
    public void setLength(BigDecimal length) {
        this.length = length;
    }

    /**
     * 宽度
     */
    public BigDecimal getWidth() {
        return width;
    }

    /**
     * 宽度
     */
    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    /**
     * 高度
     */
    public BigDecimal getHeight() {
        return height;
    }

    /**
     * 高度
     */
    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    /**
     * 是否新品
     */
    public String getIsnewProduct() {
        return isnewProduct;
    }

    /**
     * 是否新品
     */
    public void setIsnewProduct(String isnewProduct) {
        this.isnewProduct = isnewProduct;
    }

    /**
     * 是否销售
     */
    public String getIssales() {
        return issales;
    }

    /**
     * 是否销售
     */
    public void setIssales(String issales) {
        this.issales = issales;
    }

    /**
     * 是否停产
     */
    public String getIsstopProduction() {
        return isstopProduction;
    }

    /**
     * 是否停产
     */
    public void setIsstopProduction(String isstopProduction) {
        this.isstopProduction = isstopProduction;
    }

    /**
     * 是否暂停生产
     */
    public String getIssuspendProduction() {
        return issuspendProduction;
    }

    /**
     * 是否暂停生产
     */
    public void setIssuspendProduction(String issuspendProduction) {
        this.issuspendProduction = issuspendProduction;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 状态
     */
    public String getProductStatus() {
        return productStatus;
    }

    /**
     * 状态
     */
    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    /**
     * 出货仓库
     */
    public String getShippingWarehouse() {
        return shippingWarehouse;
    }

    /**
     * 出货仓库
     */
    public void setShippingWarehouse(String shippingWarehouse) {
        this.shippingWarehouse = shippingWarehouse;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Product other = (Product) that;
        return (this.getProductCode() == null ? other.getProductCode() == null : this.getProductCode().equals(other.getProductCode()))
            && (this.getProductLine() == null ? other.getProductLine() == null : this.getProductLine().equals(other.getProductLine()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getProductAbbreviation() == null ? other.getProductAbbreviation() == null : this.getProductAbbreviation().equals(other.getProductAbbreviation()))
            && (this.getUomCode() == null ? other.getUomCode() == null : this.getUomCode().equals(other.getUomCode()))
            && (this.getUomName() == null ? other.getUomName() == null : this.getUomName().equals(other.getUomName()))
            && (this.getSpecifications() == null ? other.getSpecifications() == null : this.getSpecifications().equals(other.getSpecifications()))
            && (this.getCategoryCode() == null ? other.getCategoryCode() == null : this.getCategoryCode().equals(other.getCategoryCode()))
            && (this.getCategoryName() == null ? other.getCategoryName() == null : this.getCategoryName().equals(other.getCategoryName()))
            && (this.getProductModel() == null ? other.getProductModel() == null : this.getProductModel().equals(other.getProductModel()))
            && (this.getAftersalesModel() == null ? other.getAftersalesModel() == null : this.getAftersalesModel().equals(other.getAftersalesModel()))
            && (this.getProductColor() == null ? other.getProductColor() == null : this.getProductColor().equals(other.getProductColor()))
            && (this.getBarCode() == null ? other.getBarCode() == null : this.getBarCode().equals(other.getBarCode()))
            && (this.getRetailPrice() == null ? other.getRetailPrice() == null : this.getRetailPrice().equals(other.getRetailPrice()))
            && (this.getPickupPrice() == null ? other.getPickupPrice() == null : this.getPickupPrice().equals(other.getPickupPrice()))
            && (this.getTicketPrice() == null ? other.getTicketPrice() == null : this.getTicketPrice().equals(other.getTicketPrice()))
            && (this.getStandardPrice() == null ? other.getStandardPrice() == null : this.getStandardPrice().equals(other.getStandardPrice()))
            && (this.getPremiumRatio() == null ? other.getPremiumRatio() == null : this.getPremiumRatio().equals(other.getPremiumRatio()))
            && (this.getPremiumLimit() == null ? other.getPremiumLimit() == null : this.getPremiumLimit().equals(other.getPremiumLimit()))
            && (this.getEffectiveDate() == null ? other.getEffectiveDate() == null : this.getEffectiveDate().equals(other.getEffectiveDate()))
            && (this.getExpirationTime() == null ? other.getExpirationTime() == null : this.getExpirationTime().equals(other.getExpirationTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getModifyBy() == null ? other.getModifyBy() == null : this.getModifyBy().equals(other.getModifyBy()))
            && (this.getSalesAttributes() == null ? other.getSalesAttributes() == null : this.getSalesAttributes().equals(other.getSalesAttributes()))
            && (this.getGasSpecies() == null ? other.getGasSpecies() == null : this.getGasSpecies().equals(other.getGasSpecies()))
            && (this.getProductAttributes() == null ? other.getProductAttributes() == null : this.getProductAttributes().equals(other.getProductAttributes()))
            && (this.getVolume() == null ? other.getVolume() == null : this.getVolume().equals(other.getVolume()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getLength() == null ? other.getLength() == null : this.getLength().equals(other.getLength()))
            && (this.getWidth() == null ? other.getWidth() == null : this.getWidth().equals(other.getWidth()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getIsnewProduct() == null ? other.getIsnewProduct() == null : this.getIsnewProduct().equals(other.getIsnewProduct()))
            && (this.getIssales() == null ? other.getIssales() == null : this.getIssales().equals(other.getIssales()))
            && (this.getIsstopProduction() == null ? other.getIsstopProduction() == null : this.getIsstopProduction().equals(other.getIsstopProduction()))
            && (this.getIssuspendProduction() == null ? other.getIssuspendProduction() == null : this.getIssuspendProduction().equals(other.getIssuspendProduction()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getProductStatus() == null ? other.getProductStatus() == null : this.getProductStatus().equals(other.getProductStatus()))
            && (this.getShippingWarehouse() == null ? other.getShippingWarehouse() == null : this.getShippingWarehouse().equals(other.getShippingWarehouse()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductCode() == null) ? 0 : getProductCode().hashCode());
        result = prime * result + ((getProductLine() == null) ? 0 : getProductLine().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getProductAbbreviation() == null) ? 0 : getProductAbbreviation().hashCode());
        result = prime * result + ((getUomCode() == null) ? 0 : getUomCode().hashCode());
        result = prime * result + ((getUomName() == null) ? 0 : getUomName().hashCode());
        result = prime * result + ((getSpecifications() == null) ? 0 : getSpecifications().hashCode());
        result = prime * result + ((getCategoryCode() == null) ? 0 : getCategoryCode().hashCode());
        result = prime * result + ((getCategoryName() == null) ? 0 : getCategoryName().hashCode());
        result = prime * result + ((getProductModel() == null) ? 0 : getProductModel().hashCode());
        result = prime * result + ((getAftersalesModel() == null) ? 0 : getAftersalesModel().hashCode());
        result = prime * result + ((getProductColor() == null) ? 0 : getProductColor().hashCode());
        result = prime * result + ((getBarCode() == null) ? 0 : getBarCode().hashCode());
        result = prime * result + ((getRetailPrice() == null) ? 0 : getRetailPrice().hashCode());
        result = prime * result + ((getPickupPrice() == null) ? 0 : getPickupPrice().hashCode());
        result = prime * result + ((getTicketPrice() == null) ? 0 : getTicketPrice().hashCode());
        result = prime * result + ((getStandardPrice() == null) ? 0 : getStandardPrice().hashCode());
        result = prime * result + ((getPremiumRatio() == null) ? 0 : getPremiumRatio().hashCode());
        result = prime * result + ((getPremiumLimit() == null) ? 0 : getPremiumLimit().hashCode());
        result = prime * result + ((getEffectiveDate() == null) ? 0 : getEffectiveDate().hashCode());
        result = prime * result + ((getExpirationTime() == null) ? 0 : getExpirationTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getModifyBy() == null) ? 0 : getModifyBy().hashCode());
        result = prime * result + ((getSalesAttributes() == null) ? 0 : getSalesAttributes().hashCode());
        result = prime * result + ((getGasSpecies() == null) ? 0 : getGasSpecies().hashCode());
        result = prime * result + ((getProductAttributes() == null) ? 0 : getProductAttributes().hashCode());
        result = prime * result + ((getVolume() == null) ? 0 : getVolume().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getLength() == null) ? 0 : getLength().hashCode());
        result = prime * result + ((getWidth() == null) ? 0 : getWidth().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getIsnewProduct() == null) ? 0 : getIsnewProduct().hashCode());
        result = prime * result + ((getIssales() == null) ? 0 : getIssales().hashCode());
        result = prime * result + ((getIsstopProduction() == null) ? 0 : getIsstopProduction().hashCode());
        result = prime * result + ((getIssuspendProduction() == null) ? 0 : getIssuspendProduction().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getProductStatus() == null) ? 0 : getProductStatus().hashCode());
        result = prime * result + ((getShippingWarehouse() == null) ? 0 : getShippingWarehouse().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productCode=").append(productCode);
        sb.append(", productLine=").append(productLine);
        sb.append(", productName=").append(productName);
        sb.append(", productAbbreviation=").append(productAbbreviation);
        sb.append(", uomCode=").append(uomCode);
        sb.append(", uomName=").append(uomName);
        sb.append(", specifications=").append(specifications);
        sb.append(", categoryCode=").append(categoryCode);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", productModel=").append(productModel);
        sb.append(", aftersalesModel=").append(aftersalesModel);
        sb.append(", productColor=").append(productColor);
        sb.append(", barCode=").append(barCode);
        sb.append(", retailPrice=").append(retailPrice);
        sb.append(", pickupPrice=").append(pickupPrice);
        sb.append(", ticketPrice=").append(ticketPrice);
        sb.append(", standardPrice=").append(standardPrice);
        sb.append(", premiumRatio=").append(premiumRatio);
        sb.append(", premiumLimit=").append(premiumLimit);
        sb.append(", effectiveDate=").append(effectiveDate);
        sb.append(", expirationTime=").append(expirationTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifyBy=").append(modifyBy);
        sb.append(", salesAttributes=").append(salesAttributes);
        sb.append(", gasSpecies=").append(gasSpecies);
        sb.append(", productAttributes=").append(productAttributes);
        sb.append(", volume=").append(volume);
        sb.append(", weight=").append(weight);
        sb.append(", length=").append(length);
        sb.append(", width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", isnewProduct=").append(isnewProduct);
        sb.append(", issales=").append(issales);
        sb.append(", isstopProduction=").append(isstopProduction);
        sb.append(", issuspendProduction=").append(issuspendProduction);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remarks=").append(remarks);
        sb.append(", productStatus=").append(productStatus);
        sb.append(", shippingWarehouse=").append(shippingWarehouse);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}