package org.zkoss;

import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.MatchMedia;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.entity.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartVM {
	private List<Item> _shopItems = new ArrayList<Item>();
	private String _layoutTemplate = "desktop_layout" ;
	@Init
	public void init() {
		_shopItems.add(new Item("ZK Framework PE", "#", "img/zk.png", 899f, 1, 10));
		_shopItems.add(new Item("ZK SpreadSheet", "#", "img/zkspreadsheet.png", 899f, 1, 10));
		_shopItems.add(new Item("ZK Charts", "#", "img/zkcharts.png", 899f, 1, 10));
	}

	@MatchMedia("all and (max-width : 640px)")
	@NotifyChange("layoutTemplate")
	private void switchMobileTemplate(){
		_layoutTemplate = "mobile_layout";
	}

	@MatchMedia("all and (min-width : 641px)")
	@NotifyChange("layoutTemplate")
	private void switchDesktopTemplate(){
		_layoutTemplate = "desktop_layout";
	}

	public String getLayoutTemplate() {
		return _layoutTemplate;
	}

	public List<Item> getShopItems() {
		return _shopItems;
	}

	public int getShopItemsCount() {return _shopItems.size();}

	public float getTotalPrice(){
		BigDecimal totalPrice = new BigDecimal(0);
		for(Item item : _shopItems){
			totalPrice = totalPrice.add(new BigDecimal(item.getPrice().toString()).multiply(new BigDecimal(item.getQuantity().toString())));
		}
		return totalPrice.floatValue();
	}
}
