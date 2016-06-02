package org.zkoss.entity;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String _name;
    private String _imageUrl;
    private String _url;
    private Float _price;
    private Integer _quantity;
    private Integer _stock;

    public Item(String _name, String _url, String _imageUrl, float price, int _quantity, int stock) {
        this._name = _name;
        this._imageUrl = _imageUrl;
        this._url = _url;
        this._price = price;
        this._quantity = _quantity;
        this._stock = Math.min(stock, 10) ;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getImageUrl() {
        return _imageUrl;
    }

    public void setImageUrl(String _imageUrl) {
        this._imageUrl = _imageUrl;
    }

    public String getUrl() {
        return _url;
    }

    public void setUrl(String _url) {
        this._url = _url;
    }

    public Float getPrice() {
        return _price;
    }

    public void setPrice(Float price) {
        this._price = price;
    }

    public Integer getQuantity() {
        return _quantity;
    }

    public void setQuantity(Integer _quantity) {
        this._quantity = _quantity;
    }

    public Integer getStock() {
        return this._stock;
    }

    public List<Integer> getStockList() {
        List<Integer> list = new ArrayList<Integer>();
        for ( int i = 0 ; i <= _stock; i++) {
            list.add(i);
        }
        return list;
    }
}