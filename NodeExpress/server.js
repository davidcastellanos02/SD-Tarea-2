const express = require('express')
const app = express()
const port = 3000

let list = ["lola", "pepe", "lucas", "lolo"]

app.get('/list/:position', (req, res) => {
    res.send(list[req.params.position])
})

app.listen(port)