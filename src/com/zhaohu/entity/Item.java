package com.zhaohu.entity;

import com.zhaohu.utils.GlobalConsts.ItemTypes;
import static com.zhaohu.utils.GlobalConsts.ItemTypes.P;

public class Item {
    private int itemId;
    private int price;
    private ItemTypes type = P;
    private String name;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ItemTypes getType() {
        return type;
    }

    public void setType(ItemTypes type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
