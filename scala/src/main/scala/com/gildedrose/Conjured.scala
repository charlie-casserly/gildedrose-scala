package com.gildedrose

class Conjured extends Items {

  override def tick(item: Item): Unit = {
    if (item.quality > 0) {
      item.quality -= 2
      if (item.sellIn <= 0) item.quality -= 1
      item.sellIn -= 2
    }
  }

}