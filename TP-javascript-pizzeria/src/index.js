import log from './toto.js'
import moment from 'moment'
import Pizza from './pizza'
import { toppings as authorizedToppings } from './toppings.js'
import { PizzaDB } from './pizza-list.js'

log('il est ' + moment().format('LTS')
)

var pizza
var pizzaDB = new PizzaDB()
var pizzaEnCours
var button = document.getElementById('addPizza').addEventListener('click', function (evt) {
  pizzaEnCours = document.getElementById('nompizza').value
  pizza = new Pizza(pizzaEnCours)
  console.log('Bing ! Pizza '+pizzaEnCours+' créé')
}, false)

var button2 = document.getElementById('eggs').addEventListener('click', function (evt) {
  pizza.addTopping('eggs')
  console.log('Bing ! un oeuf !')
}, false)

var button3 = document.getElementById('mushrooms').addEventListener('click', function (evt) {
  pizza.addTopping('mushrooms')
  console.log('Bing ! des champis !')
}, false)

var button4 = document.getElementById('savePizza').addEventListener('click', function (evt) {
  console.log(pizza)
  pizzaDB.addPizza(pizza)
  console.log('Bing ! Pizza '+pizzaEnCours+' enregistré avec '+pizza.toppings)
}, false)



// setTimeout(function () {
//   p.cook(1000)
//     .then(() => {
//       console.log('Bing ! Pizza cuite')
//     })
//     .catch(err => {
//       console.log(err)
//     })
// }, 1000)

// console.log('liste des ingrédients :')
// authorizedToppings.forEach(function (item, index, array) {
//   console.log('   -   ' + item)
// }, this)

// var pizzas = new PizzaList()
//   .addPizza(p)
//   .addPizza(pp)

// console.log(pizzas)

// console.log(pizzas.searchPizza('onion'))

// function getAvg (array) {
//   return array.reduce((acc, cv, idx, arr) => acc + cv / arr.length, 0)
// }

// let cacheOfUsers = null

// function getUsers () {
//   // si cache existe l'utiliser
//   console.log(cacheOfUsers)
//   if (cacheOfUsers) {
//     console.log('cacheOfUsers cache' + cacheOfUsers)
//     return Promise.resolve(cacheOfUsers)
//   }

//   // sinon faire la requête et mettre en cache
//   return fetch('users.json')
//     // tranforme la réponse http en json
//     .then((response) => {
//       if (!response.ok) throw Error(response.status)
//       // cacheOfUsers = response.json()
//       // console.log('cacheOfUsers http' + cacheOfUsers)
//       return response.json()
//     })
//     .then(users => {
//       cacheOfUsers = users
//       return users
//     })
// }

// getUsers()
//   .then(users => {
//     console.log('1', users)
//   })

// setTimeout(function () {
//   getUsers()
//     .then(users => {
//       console.log('2', users)
//     })
//   },2000)

// function getuserAge (api) {
//   return fetch(api)
//     .then((response) => {
//       // if (!response.ok) throw Error(response.status)
//       return response.json()
//     })
//     .then(user => {
//       console.log(user.age)
//       return user.age
//     })
// }

// var user1 = getuser('users.json')
// var user2 = getuser('users1.json')
// var user3 = getuser('users2.json')
// getuser('users.json').then(user => console.log(user))

// Promise.all([getuserAge('users.json'), getuserAge('users1.json'), getuserAge('users2.json')])

//   .then(userAge => {
//     console.log('userAge : ' + userAge)
//     console.log('moyenne des ages : ' + getAvg(userAge)) })
//   .catch(err => console.log(err))

// console.log(getAvg(users))
// console.log('test ' + getuser('users.json'))

// fetch('users2.json')
//   .then((response) => {
//     if (!response.ok) throw Error(response.status)
//     return response.json()
//   })
//   .then(users => {
//     return users.map(user => user.age)
//   })
//   .then(ages => {
//     return getAvg(ages)
//   })
//   .then(age => {
//     console.log('moyenne des âges', age)
//   })
//   .catch(err => {
//     console.log(err)
//   })
