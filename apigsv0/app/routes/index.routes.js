const planController = require("../controllers/planes.controller")
const proyectosController = require("../controllers/proyectos.controller")
module.exports = app => {
  app.get("/api", (req, res) => {
    res.status(200).send({
      data: "Welcome Node Sequlize API v1",
    })
  })
  // planes routes
  app.get("/api/planes", planController.getAllPlanes)
  app.post("/api/planes", planController.createPlan)
  app.put("/api/planes/:id", planController.updatePlan)
  app.get("/api/planes/:id", planController.getPlan)
  app.delete("/api/planes/:id", planController.deletePlan)

    // proyectos routes
    app.get("/api/proyectos", proyectosController.getAllProyectos)
    app.post("/api/proyectos", proyectosController.createProyecto)
    app.put("/api/proyectos/:id", proyectosController.updateProyecto)
    app.get("/api/proyectos/:id", proyectosController.getProyecto)
    app.delete("/api/proyectos/:id", proyectosController.deleteProyecto)
}