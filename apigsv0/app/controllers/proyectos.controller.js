const Proyecto = require("../models").proyectos
module.exports = {
    async getAllProyectos(req, res) {
        try {
            const data = await Proyecto.findAll()
            res.status(201).send({
                'estado': true,
                'msg': "¡Listado con éxito!",
                'data': data
            })
        } catch (e) {
            console.log(e)
            res.status(500).send(e)
        }
    },
    async createProyecto(req, res) {
        try {
            const data = await Proyecto.create({
                proyecto: req.body.proyecto,
                costo: req.body.costo,
                fe_inicio: req.body.fe_inicio,
                fe_fin: req.body.fe_fin,   
                estado: req.body.estado,   
            })
            res.status(201).send({
                'estado': true,
                'msg': "¡Creado con exito!",
                'data': data
            })
        } catch (e) {
            console.log(e)
            res.status(400).send(e)
        }
    },
    async updateProyecto(req, res) {
        try {
            const data = await Proyecto.findOne({
                where: {
                    id: req.params.id
                }
            })
            if (data) {
                const updated = await data.update({
                    proyecto: req.body.proyecto,
                    costo: req.body.costo,
                    fe_inicio: req.body.fe_inicio,
                    fe_fin: req.body.fe_fin,
                    estado: req.body.estado, 
                })
                res.status(201).send({
                    'estado': true,
                    'msg': "¡Actualizado con éxito!",
                    'data': updated
                })
            } else {
                res.status(404).send("¡No encontrado!")
            }
        } catch (e) {
            console.log(e)
            res.status(500).send(e)
        }
    },
    async deleteProyecto(req, res) {
        try {
            const data = await Proyecto.destroy({
                where: { id: req.params.id }
            })
            res.status(201).send({
                'estado': true,
                'msg': "¡Eliminado con éxito!",
                'data': data
            })
        } catch (e) {
            console.log(e)
            res.status(500).send(e)
        }
    },
    async getProyecto(req, res) {
        try {
            const data = await Proyecto.findOne({
                where: {
                    id: req.params.id
                }
            })
            if (data) {
                res.status(201).send({
                    'estado': true,
                    'msg': "¡Seleccionado con éxito!",
                    'data': data
                })
            }
        } catch (e) {
            console.log(e)
            res.status(500).send(e)
        }
    }
}