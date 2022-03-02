package com.gildedrose

class GildedRose(val items: Array[Item]) {

  def updateQuality() {
    for (i <- 0 until items.length) qualityChecker(items(i))
  }

  private def qualityChecker(item: Item) {

    val item_instance = item.name match {
      case "Normal" => new Normal
      case "Aged Brie" => new Brie
      case "Backstage passes to a TAFKAL80ETC concert" => new BackstagePass
      case "Conjured" => new Conjured
      case "Sulfuras, Hand of Ragnaros" => new Items
    }

    item_instance.tick(item)

  }

}