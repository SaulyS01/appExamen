const Plan = require("../models").planes
module.exports = {
    async getAllPlanes(req, res) {
        try {
            const data = await Plan.findAll()
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
    async createPlan(req, res) {
        try {
            const data = await Plan.create({
                plan: req.body.plan,
                codigo: req.body.codigo,
                estado: req.body.estado,
                id_proyecto: req.body.id_proyecto
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
    async updatePlan(req, res) {
        try {
            const data = await Plan.findOne({
                where: {
                    id: req.params.id
                }
            })
            if (data) {
                const updated = await data.update({
                    plan: req.body.plan,
                    codigo: req.body.codigo,
                    estado: req.body.estado,
                    id_proyecto: req.body.id_proyecto
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
    async deletePlan(req, res) {
        try {
            const data = await Plan.destroy({
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
    async getPlan(req, res) {
        try {
            const data = await Plan.findOne({
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