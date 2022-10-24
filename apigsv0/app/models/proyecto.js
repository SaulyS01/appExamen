'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class Proyecto extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      Proyecto.hasMany(models.planes, {
        foreignKey: 'id_proyecto', as: 'planes',
      })
    }
  }
  Proyecto.init({
    proyecto: DataTypes.STRING(100),
    costo: DataTypes.INTEGER,
    fe_inicio: DataTypes.STRING,
    fe_fin: DataTypes.STRING,
    estado: DataTypes.CHAR(1)
  }, {
    sequelize,
    modelName: 'proyectos',
  });
  return Proyecto;
};