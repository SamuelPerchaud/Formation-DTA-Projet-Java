import Dexie from 'dexie'

export class PizzaDB {
  constructor () {
    this.db = new Dexie('pizzeria')
    this.db.version(1).stores({
      pizzas: '++id, name'
    })
    this.db.open()
  }

  addPizza (pizza) {
    return this.db.pizzas.add(pizza)
  }

  searchPizza (topping) {
    var tab = []
    this.pizzas.forEach(function (item, array, index) {
      if (!item.toppings.indexOf(topping))
        tab.push(item)
    }, this)
    return tab
  }

}
