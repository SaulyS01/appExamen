'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class Plan extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      Plan.belongsTo(models.proyectos, {
        foreignKey: 'id',
        target_key: 'id_proyecto'
      })
    }
  }
  Plan.init({
    plan: DataTypes.STRING(100),
    codigo: DataTypes.STRING(50),
    estado: DataTypes.CHAR(1),
    id_proyecto: DataTypes.INTEGER
  }, {
    sequelize,
    modelName: 'planes',
  });
  return Plan;
};