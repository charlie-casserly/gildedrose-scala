package com.gildedrose

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class GildedRoseTest  extends AnyFunSpec with Matchers {
  it ("returns the name of a newly created item") {
    val items = Array[Item](new Item("Normal", 0, 0))
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).name should equal ("Normal")
  }

  it ("Sulfaras never degrades") {
    val items = Array[Item](new Item("Sulfuras, Hand of Ragnaros", 70, 70))
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).quality should equal (70)
  }

  it ("Sulfaras never has to be sold") {
    val items = Array[Item](new Item("Sulfuras, Hand of Ragnaros", 70, 70))
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).sellIn should equal (70)
  }

  it ("items age decreases over time") {
    val items = Array[Item](new Item("Normal", 10, 10))
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).sellIn should equal (9)
  }

  it ("items past their sell by date degrade twice as fast") {
    val items = Array[Item](new Item("Normal", 0, 10))
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).quality should equal (8)
  }

  it ("the quality of an item is never negative") {
    val items = Array[Item](new Item("Normal", 0, 0))
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).quality should equal (0)
  }

  it("Quality cannot exceed 50") {
    val items = Array[Item](new Item("Aged Brie", 50, 50))
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).quality should equal (50)
  }

  it("Aged Brie increases in quality as it ages") {
    val items = Array[Item](new Item("Aged Brie", 40, 40))
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).quality should equal (41)
  }

  it("Backstage passes increase in quality as it ages")  {
    val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 40, 40))
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).quality should equal (41)
  }

  it("Backstage passes increase by 2 quality when there are 10 days or less to sell") {
    val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10))
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).quality should equal (12)
  }

  it("Backstage passes increase by 3 quality when there are 5 days or less to sell") {
    val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5))
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).quality should equal (8)
  }

  it("Backstage passes quality reduces to zero once sellby date arrives") {
    val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40))
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).quality should equal (0)
  }

  it("Conjured items degrade by 2") {
    val items = Array[Item](new Item("Conjured", 40, 40))
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).quality should equal (38)
  }

}