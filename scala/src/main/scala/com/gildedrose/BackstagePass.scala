package com.gildedrose

class BackstagePass extends Items {

  override def tick(item: Item): Unit = {
    if (item.sellIn > 0) {
      item.quality += 1
      if (item.sellIn <= 5) item.quality += 2
      else if (item.sellIn <= 10) item.quality += 1
    } else {
      item.quality = 0
    }
    item.sellIn -= 1
  }

}