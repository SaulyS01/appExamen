'use strict';
/** @type {import('sequelize-cli').Migration} */
module.exports = {
  async up(queryInterface, Sequelize) {
    await queryInterface.createTable('proyectos', {
      id: {
        allowNull: false,
        autoIncrement: true,
        primaryKey: true,
        type: Sequelize.INTEGER
      },
      proyecto: {
        type: Sequelize.STRING(100)
      },
      costo: {
        type: Sequelize.INTEGER
      },
      fe_inicio: {
        type: Sequelize.STRING
      },
      fe_fin: {
        type: Sequelize.STRING
      },
      estado: {
        type: Sequelize.CHAR(1)
      },
      createdAt: {
        type: Sequelize.DATE
      },
      updatedAt: {
        type: Sequelize.DATE
      }
    });
  },
  async down(queryInterface, Sequelize) {
    await queryInterface.dropTable('proyectos');
  }
};