package com.reza.ecommerse.model.master;

import com.reza.ecommerse.model.common.BaseModel;
import com.reza.ecommerse.model.file.File;
import com.reza.ecommerse.model.master.Item;

import javax.persistence.*;

@Entity
@Table(name = "feed")
public class Feed extends BaseModel {
    private Item item;
    private File file;
    private String detailFeed;

    @ManyToOne
    @JoinColumn(name = "item_id")
    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }

    @ManyToOne
    @JoinColumn(name = "file_id")
    public File getFile() { return file; }
    public void setFile(File file) { this.file = file; }

    @Column(name = "detail_feed")
    public String getDetailFeed() { return detailFeed; }
    public void setDetailFeed(String detailFeed) { this.detailFeed = detailFeed; }
}
