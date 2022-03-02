package com.gildedrose

class Normal extends Items {

  override def tick(item: Item): Unit = {
    if (item.quality > 0) {
      item.quality -= 1
      if (item.sellIn <= 0) item.quality -= 1
      item.sellIn -= 1
    }
  }

}