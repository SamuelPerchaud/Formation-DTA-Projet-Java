import { toppings as authorizedToppings } from './toppings.js'

export default class Pizza {
  constructor (name) {
    this.name = name
    this.toppings = []
    this.status = 0 // 0 === crue, 1 === en cours de cuisson, 2 === cuite
  }

  addTopping (topping) {
    if ( (Object.keys(authorizedToppings).indexOf(topping) === -1)) return this

    // 2 toppings
    if (this.toppings.filter(t => t === topping).length > 1) return this

    this.toppings.push(topping)
    return this
  }

  setName (name) {
    this.name = name
    return this
  }

cook (time = 1000) {
    return new Promise((resolve, reject) => {
      if (this.status === 1) return reject('Pizza en cours de cuisson')
      if (this.status === 2) return reject('Pizza déjà cuite')

      this.status = 1
      setTimeout(() => {
        this.status = 2
        resolve(this)
      }, time)
    })
  }

  deleteToppings (toppings) {
    // this.toppings.splice(this.toppings.lastIndexOf(toppings), 1)
    if (this.toppings.lastIndexOf(toppings) !== -1) {
      this.toppings.splice(this.toppings.lastIndexOf(toppings), 1)
    }
    return this
  }
  translate (topping, lang = 'en') {
    return authorizedToppings[topping][lang] || topping
  }

  toppings2string (lang = 'en') {
    return this.toppings

      // uniqs
      .reduce((acc, topping) => {
        if (acc.indexOf(topping) === -1) acc.push(topping)
        return acc
      }, [])

      // topping (translated (nb))
      .map(topping => {
        const size = this.toppings.filter(item => item === topping).length
        if (size > 1) return `${this.translate(topping, lang)} x${size}`
        return `${this.translate(topping, lang)}`
      })
      .join(', ')
  }
}
