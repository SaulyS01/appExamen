const express = require("express")
const bodyParser = require("body-parser")
const cors = require('cors');

const app = express()
app.use(cors());
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended: false }))

require("./app/routes/index.routes")(app)
const PORT = 4040
app.listen(PORT, () => {
  console.log(`Server is listening to port http://localhost:${PORT}`)
})