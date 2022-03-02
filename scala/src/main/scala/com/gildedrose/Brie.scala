package com.gildedrose

class Brie extends Items {

  override def tick(item: Item): Unit = {
    if (item.quality < 50) item.quality += 1
    item.sellIn -= 1
  }

}