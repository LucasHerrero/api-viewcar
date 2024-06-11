-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: db
-- Tiempo de generación: 10-04-2024 a las 07:24:46
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `viewcar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `appoinments`
--

CREATE TABLE `appoinments` (
  `appoinment_id` int NOT NULL,
  `appoinment_creationtime` datetime(6) DEFAULT NULL,
  `appoinment_date` date DEFAULT NULL,
  `appoinment_time` time(6) DEFAULT NULL,
  `appoinment_car` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `brand`
--

CREATE TABLE `brand` (
  `brand_id` int NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_of_discharge` date DEFAULT NULL,
  `date_of_termination` date DEFAULT NULL,
  `user_changes` varchar(255) DEFAULT NULL,
  `brand_brand` varchar(255) DEFAULT NULL,
  `brand_image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `brand`
--

INSERT INTO `brand` (`brand_id`, `date_modified`, `date_of_discharge`, `date_of_termination`, `user_changes`, `brand_brand`, `brand_image`) VALUES
(1, NULL, NULL, NULL, NULL, 'Audi', '/assets/images/marcas/audi.webp'),
(5, NULL, NULL, NULL, NULL, 'Volkswagen', '/assets/images/marcas/vw.webp'),
(7, NULL, NULL, NULL, NULL, 'Cupra', '/assets/images/marcas/cupra.webp'),
(8, NULL, NULL, NULL, NULL, 'Seat', '/assets/images/marcas/seat.webp');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `car`
--

CREATE TABLE `car` (
  `car_id` int NOT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `car_price` float DEFAULT NULL,
  `brand_id` int DEFAULT NULL,
  `car_engine_id` int DEFAULT NULL,
  `ext_color_id` int DEFAULT NULL,
  `int_color_id` int DEFAULT NULL,
  `model_id` int DEFAULT NULL,
  `package_id` int DEFAULT NULL,
  `tire_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `car_engine`
--

CREATE TABLE `car_engine` (
  `car_engine_id` int NOT NULL,
  `car_engine_consumption` varchar(255) DEFAULT NULL,
  `car_engine_description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `car_engine_emission` varchar(255) DEFAULT NULL,
  `car_engine_fuel` varchar(255) DEFAULT NULL,
  `car_engine_name` varchar(255) DEFAULT NULL,
  `car_engine_power` varchar(255) DEFAULT NULL,
  `car_engine_price` float DEFAULT NULL,
  `car_engine_transmission` varchar(255) DEFAULT NULL,
  `fk_model` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `car_engine`
--

INSERT INTO `car_engine` (`car_engine_id`, `car_engine_consumption`, `car_engine_description`, `car_engine_emission`, `car_engine_fuel`, `car_engine_name`, `car_engine_power`, `car_engine_price`, `car_engine_transmission`, `fk_model`) VALUES
(1, '5.4', 'La información relativa al consumo de combustible y las emisiones de CO2 ha sido determinada de conformidad con los procedimientos de medición contemplados por la normativa WLTP. El equipamiento opcional (partes accesorias, diferentes formatos de neumático, etc.) pueden afectar a valores relevantes de los vehículos, como el peso, la resistencia y la aerodinámica. Estos factores, junto con la climatología, las condiciones del tráfico y la forma de conducción, pueden afectar el consumo de combustible, el consumo de electricidad, las emisiones CO2 y las prestaciones del vehículo. ', '122', 'Gasolina', '1.0 TSI', '110', 3200, 'Manual', 2),
(2, '5.4', 'La información relativa al consumo de combustible y las emisiones de CO2 ha sido determinada de conformidad con los procedimientos de medición contemplados por la normativa WLTP. El equipamiento opcional (partes accesorias, diferentes formatos de neumático, etc.) pueden afectar a valores relevantes de los vehículos, como el peso, la resistencia y la aerodinámica. Estos factores, junto con la climatología, las condiciones del tráfico y la forma de conducción, pueden afectar el consumo de combustible, el consumo de electricidad, las emisiones CO2 y las prestaciones del vehículo. ', '121', 'Gasolina', '1.5 TSI', '130', 4010, 'Manual', 2),
(3, '5.9', 'La información relativa al consumo de combustible y las emisiones de CO2 ha sido determinada de conformidad con los procedimientos de medición contemplados por la normativa WLTP. El equipamiento opcional (partes accesorias, diferentes formatos de neumático, etc.) pueden afectar a valores relevantes de los vehículos, como el peso, la resistencia y la aerodinámica. Estos factores, junto con la climatología, las condiciones del tráfico y la forma de conducción, pueden afectar el consumo de combustible, el consumo de electricidad, las emisiones CO2 y las prestaciones del vehículo. ', '134', 'Gasolina', '1.0 TSI', '110', 3200, 'Manual', 6),
(4, '4.6', 'La información relativa al consumo de combustible y las emisiones de CO2 ha sido determinada de conformidad con los procedimientos de medición contemplados por la normativa WLTP. El equipamiento opcional (partes accesorias, diferentes formatos de neumático, etc.) pueden afectar a valores relevantes de los vehículos, como el peso, la resistencia y la aerodinámica. Estos factores, junto con la climatología, las condiciones del tráfico y la forma de conducción, pueden afectar el consumo de combustible, el consumo de electricidad, las emisiones CO2 y las prestaciones del vehículo. ', '122', 'Diésel', '1.5 TSI', '115', 3500, 'Manual', 6),
(6, '7.2', 'La información relativa al consumo de combustible y las emisiones ha sido determinada de conformidad con los procedimientos de medición contemplados por la normativa WLTP, en vigor desde el 1 de septiembre de 2018 . El equipamiento opcional (partes accesorias, diferentes formatos de neumático, etc.) pueden afectar a valores relevantes de los vehículos, como el peso, la resistencia y la aerodinámica. Estos factores, junto con la climatología, las condiciones del tráfico y la forma de conducción, pueden afectar el consumo de combustible, el consumo de electricidad, las emisiones CO2 y las prestaciones del vehículo. ', '164', 'Gasolina', '35 TFSI s', '110', 3200, 'Manual', 1),
(7, '5.4', 'La información relativa al consumo de combustible y las emisiones ha sido determinada de conformidad con los procedimientos de medición contemplados por la normativa WLTP, en vigor desde el 1 de septiembre de 2018 . El equipamiento opcional (partes accesorias, diferentes formatos de neumático, etc.) pueden afectar a valores relevantes de los vehículos, como el peso, la resistencia y la aerodinámica. Estos factores, junto con la climatología, las condiciones del tráfico y la forma de conducción, pueden afectar el consumo de combustible, el consumo de electricidad, las emisiones CO2 y las prestaciones del vehículo. ', '142', 'Diésel', '30 TDI s', '100', 3000, 'Manual', 1),
(9, '6.9', 'La información relativa al consumo de combustible y las emisiones ha sido determinada de conformidad con los procedimientos de medición contemplados por la normativa WLTP, en vigor desde el 1 de septiembre de 2018 . El equipamiento opcional (partes accesorias, diferentes formatos de neumático, etc.) pueden afectar a valores relevantes de los vehículos, como el peso, la resistencia y la aerodinámica. Estos factores, junto con la climatología, las condiciones del tráfico y la forma de conducción, pueden afectar el consumo de combustible, el consumo de electricidad, las emisiones CO2 y las prestaciones del vehículo. ', '153', 'Gasolina', '40 TFSI s', '150', 4000, 'Manual', 3),
(10, '1.2', 'La información relativa al consumo de combustible y las emisiones de CO2 ha sido determinada de conformidad con los procedimientos de medición contemplados por la normativa WLTP. El equipamiento opcional (partes accesorias, diferentes formatos de neumático, etc.) pueden afectar a valores relevantes de los vehículos, como el peso, la resistencia y la aerodinámica. Estos factores, junto con la climatología, las condiciones del tráfico y la forma de conducción, pueden afectar el consumo de combustible, el consumo de electricidad, las emisiones CO2 y las prestaciones del vehículo. ', '28', 'Híbrido', '1.4 e', '204', 6000, 'Automatico', 4),
(11, '5.9', 'La información relativa al consumo de combustible y las emisiones de CO2 ha sido determinada de conformidad con los procedimientos de medición contemplados por la normativa WLTP. El equipamiento opcional (partes accesorias, diferentes formatos de neumático, etc.) pueden afectar a valores relevantes de los vehículos, como el peso, la resistencia y la aerodinámica. Estos factores, junto con la climatología, las condiciones del tráfico y la forma de conducción, pueden afectar el consumo de combustible, el consumo de electricidad, las emisiones CO2 y las prestaciones del vehículo. ', '153', 'Diésel', '2.0 TDI', '150', 4150, 'Manual', 4),
(12, '8', 'La información relativa al consumo de combustible y las emisiones de CO2 ha sido determinada de conformidad con los procedimientos de medición contemplados por la normativa WLTP. El equipamiento opcional (partes accesorias, diferentes formatos de neumático, etc.) pueden afectar a valores relevantes de los vehículos, como el peso, la resistencia y la aerodinámica. Estos factores, junto con la climatología, las condiciones del tráfico y la forma de conducción, pueden afectar el consumo de combustible, el consumo de electricidad, las emisiones CO2 y las prestaciones del vehículo. ', '153', 'Diésel', '2.0 TDI', '190', 4600, 'Automatico', 7),
(13, '9', 'La información relativa al consumo de combustible y las emisiones de CO2 ha sido determinada de conformidad con los procedimientos de medición contemplados por la normativa WLTP. El equipamiento opcional (partes accesorias, diferentes formatos de neumático, etc.) pueden afectar a valores relevantes de los vehículos, como el peso, la resistencia y la aerodinámica. Estos factores, junto con la climatología, las condiciones del tráfico y la forma de conducción, pueden afectar el consumo de combustible, el consumo de electricidad, las emisiones CO2 y las prestaciones del vehículo. ', '202', 'Gasolina', '2.0 TSI', '300', 4500, 'Manual', 7),
(14, '5', 'La información relativa al consumo de combustible y las emisiones ha sido determinada de conformidad con los procedimientos de medición contemplados por la normativa WLTP, en vigor desde el 1 de septiembre de 2018 . El equipamiento opcional (partes accesorias, diferentes formatos de neumático, etc.) pueden afectar a valores relevantes de los vehículos, como el peso, la resistencia y la aerodinámica. ', '120', 'Gasolina', '1.0 TSI ', '95', 2900, 'Manual', 8),
(15, '5', 'La información relativa al consumo de combustible y las emisiones ha sido determinada de conformidad con los procedimientos de medición contemplados por la normativa WLTP, en vigor desde el 1 de septiembre de 2018 . El equipamiento opcional (partes accesorias, diferentes formatos de neumático, etc.) pueden afectar a valores relevantes de los vehículos, como el peso, la resistencia y la aerodinámica. Estos factores, junto con la climatología, las condiciones del tráfico y la forma de conducción, pueden afectar el consumo de combustible, el consumo de electricidad, las emisiones CO2 y las prestaciones del vehículo. ', '120', 'Gasolina', '1.0 TSI ', '110', 3200, 'Manual', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `exterior_color`
--

CREATE TABLE `exterior_color` (
  `ext_color_id` int NOT NULL,
  `ext_color_color_img` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `ext_color_color` varchar(255) DEFAULT NULL,
  `ext_color_image` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `ext_color_price` float DEFAULT NULL,
  `fk_package` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `exterior_color`
--

INSERT INTO `exterior_color` (`ext_color_id`, `ext_color_color_img`, `ext_color_color`, `ext_color_image`, `ext_color_price`, `fk_package`) VALUES
(6, '\\assets\\images\\colores\\golf\\life\\imgColor\\circulo-golf-blanco.webp', 'Blanco', '/assets/images/paquetes/vw/golf/Life/life.webp,/assets/images/paquetes/vw/golf/Life/frontal-life.webp,/assets/images/paquetes/vw/golf/Life/lateral-life.webp,/assets/images/paquetes/vw/golf/Life/trasera-life.webp', 235, 1),
(7, '\\assets\\images\\colores\\golf\\life\\imgColor\\circulo-golf-gris.webp', 'Gris Ceres', '\\assets\\images\\colores\\golf\\life\\angulo-golf-life-gris.webp, \\assets\\images\\colores\\golf\\life\\frontal-golf-life-gris.webp, \\assets\\images\\colores\\golf\\life\\lateral-golf-life-gris.webp, \\assets\\images\\colores\\golf\\life\\trasera-golf-life-gris.webp', 340, 1),
(8, '\\assets\\images\\colores\\golf\\rline\\imgColor\\circulo-golf-amarillo.webp', 'Amarillo Lima Metalizado', '/assets/images/paquetes/vw/golf/R/angulo-rline.webp,/assets/images/paquetes/vw/golf/R/frontal-rline.webp,/assets/images/paquetes/vw/golf/R/lateral-rline.webp,/assets/images/paquetes/vw/golf/R/trasero-rline.webp', 780, 2),
(9, '\\assets\\images\\colores\\golf\\rline\\imgColor\\circulo-golf-azul.webp', 'Azul Atlántico Metalizado', '\\assets\\images\\colores\\golf\\rline\\angulo-golf-rline-azul.webp, \\assets\\images\\colores\\golf\\rline\\frontal-golf-rline-azul.webp, \\assets\\images\\colores\\golf\\rline\\lateral-golf-rline-azul.webp, \\assets\\images\\colores\\golf\\rline\\trasera-golf-rline-azul.webp', 630, 2),
(10, '\\assets\\images\\colores\\Ibiza\\Fr\\imgColor\\circuloRojo.webp', 'Rojo', '/assets/images/paquetes/seat/Ibiza/fr/angulo-ibizafr.png, /assets/images/paquetes/seat/Ibiza/fr/frontal-ibizafr.png, /assets/images/paquetes/seat/Ibiza/fr/lateral-ibizafr.png, /assets/images/paquetes/seat/Ibiza/fr/trasera-ibizafr.png', 380, 16),
(11, '\\assets\\images\\colores\\troc\\rline\\imgColor\\circulo-troc-blanco.webp', 'Blanco', '/assets/images/paquetes/vw/vw-troc/r-line/angulo-troc-rline.webp,/assets/images/paquetes/vw/vw-troc/r-line/frontal-rline-troc.webp,/assets/images/paquetes/vw/vw-troc/r-line/lateral-rline-troc.webp,/assets/images/paquetes/vw/vw-troc/r-line/trasera-rline-troc.webp', 225, 12),
(12, '\\assets\\images\\colores\\troc\\rline\\imgColor\\circulo-troc-rojo.webp', 'Rojo Metalizado', '\\assets\\images\\colores\\troc\\rline\\angulo-troc-rline-rojo.webp, \\assets\\images\\colores\\troc\\rline\\frontal-troc-rline-rojo.webp, \\assets\\images\\colores\\troc\\rline\\lateral-troc-rline-rojo.webp, \\assets\\images\\colores\\troc\\rline\\trasera-troc-rline-rojo.webp', 750, 12),
(13, '\\assets\\images\\colores\\troc\\life\\imgColor\\circulo-troc-beige.webp', 'Beige', '/assets/images/paquetes/vw/vw-troc/life/life-troc.webp,/assets/images/paquetes/vw/vw-troc/life/frontal-life-troc.webp,/assets/images/paquetes/vw/vw-troc/life/lateral-life-troc.webp,/assets/images/paquetes/vw/vw-troc/life/trasera-troc-life.webp', 655, 11),
(14, '\\assets\\images\\colores\\troc\\life\\imgColor\\circulo-troc-azul.webp', 'Azul Ravenna Metalizado', ' \\assets\\images\\colores\\troc\\life\\angulo-troc-life-azul.webp, \\assets\\images\\colores\\troc\\life\\frontal-troc-life-azul.webp, \\assets\\images\\colores\\troc\\life\\lateral-troc-life-azul.webp, \\assets\\images\\colores\\troc\\life\\trasera-troc-life-azul.webp', 600, 11),
(15, '\\assets\\images\\colores\\Ibiza\\Fr\\imgColor\\circuloAzulSafiro.webp', 'Azul Zafiro', '\\assets\\images\\colores\\Ibiza\\Fr\\Ibizaanguloadelante.webp, \\assets\\images\\colores\\Ibiza\\Fr\\IbizaAtras.webp, \\assets\\images\\colores\\Ibiza\\Fr\\IbizaFrente.webp, \\assets\\images\\colores\\Ibiza\\Fr\\IbizaLado.webp', 520, 16),
(16, '\\assets\\images\\colores\\Ibiza\\Style\\imgColor\\circuloNegroMidnight.webp', 'Negro Midnight', '\\assets\\images\\colores\\Ibiza\\Style\\ibizaStyleanguloadelante.webp, \\assets\\images\\colores\\Ibiza\\Style\\ibizaStyleAtras.webp, \\assets\\images\\colores\\Ibiza\\Style\\IbizaStyleFrente.webp, \\assets\\images\\colores\\Ibiza\\Style\\ibizaStylelado.webp', 520, 15),
(17, '\\assets\\images\\colores\\Ibiza\\Style\\imgColor\\circuloBlanco.webp', 'Blanco', '/assets/images/paquetes/seat/Ibiza/style/angulo-ibizastyle.png,/assets/images/paquetes/seat/Ibiza/style/frontal-ibizastyle.png,/assets/images/paquetes/seat/Ibiza/style/lateral-ibizastyle.png,/assets/images/paquetes/seat/Ibiza/style/trasera-ibizastyle.png', 380, 15),
(18, '\\assets\\images\\colores\\Leon\\Fr\\imgColor\\circuloRojo.webp', 'Rojo', '/assets/images/paquetes/seat/Leon/Fr/angulo-leonfr.png, /assets/images/paquetes/seat/Leon/Fr/Frontal-leonfr.png, /assets/images/paquetes/seat/Leon/Fr/lateral-leonfr.png, /assets/images/paquetes/seat/Leon/Fr/trasera-leonfr.png', 380, 10),
(19, '\\assets\\images\\colores\\Formentor\\Vz\\imgColor\\circuloGrismetalizado.webp', 'Gris Magnetic', '\\assets\\images\\colores\\Leon\\Fr\\LeonFrangu.webp, \\assets\\images\\colores\\Leon\\Fr\\LeonFrfrente.webp, \\assets\\images\\colores\\Leon\\Fr\\LeonFrlado.webp, \\assets\\images\\colores\\Leon\\Fr\\LeonFrAngAtras.webp   ', 655, 10),
(20, '\\assets\\images\\colores\\Leon\\Style\\imgColor\\circuloGrisMetalizado.webp', 'Gris Metalizado', '/assets/images/paquetes/seat/Leon/Style/angulo-leonstyle.png, /assets/images/paquetes/seat/Leon/Style/frontal-leonstyle.png, /assets/images/paquetes/seat/Leon/Style/lateral-leonstyle.png, /assets/images/paquetes/seat/Leon/Style/trasera-leonstyle.png', 380, 9),
(21, '\\assets\\images\\colores\\Leon\\Style\\imgColor\\circuloAzulSafiro.webp', 'Azul Safiro', '\\assets\\images\\colores\\Leon\\Style\\LeonStyleAzulSafiroAngAtras.webp, \\assets\\images\\colores\\Leon\\Style\\LeonStyleAzulSafiroAngulo.webp, \\assets\\images\\colores\\Leon\\Style\\LeonStyleAzulSafiroFrente.webp, \\assets\\images\\colores\\Leon\\Style\\LeonStyleAzulSafiroLado.webp', 655, 9),
(22, '\\assets\\images\\colores\\a5\\advance\\imgColor\\circulo-a5advance-negro.webp', 'Negro Brillante', '/assets/images/paquetes/audi/a4/Advance/angulo-a4advance.webp,/assets/images/paquetes/audi/a4/Advance/frontal-a4advance.webp,/assets/images/paquetes/audi/a4/Advance/lateral-a4advance.webp,/assets/images/paquetes/audi/a4/Advance/trasera-a4advance.webp', 655, 4),
(23, '\\assets\\images\\colores\\a4\\advance\\imgColor\\circulo-a4advance-blanco.webp', 'Blanco Glaciar', '\\assets\\images\\colores\\a4\\advance\\angulo-a4advance-blanco.webp,\\assets\\images\\colores\\a4\\advance\\frontal-a4advance-blanco.webp,\\assets\\images\\colores\\a4\\advance\\lateral-a4-advance-blanco.webp,\\assets\\images\\colores\\a4\\advance\\trasera-a4advance-blanco.webp', 1220, 4),
(24, '/assets/images/colores/a4/blackline/imgColor/circulo-a4advanced-verde.webp', 'Verde Distrito Metalizado', '/assets/images/paquetes/audi/a4/Black line edition/angulo-audiblack.webp,/assets/images/paquetes/audi/a4/Black line edition/frontal-audiblack.webp,/assets/images/paquetes/audi/a4/Black line edition/lateral-audiblack.webp,/assets/images/paquetes/audi/a4/Black line edition/trasera-audiblack.webp', 780, 3),
(25, '/assets/images/colores/a4/blackline/imgColor/circulo-a4blackline-gris.webp', 'Gris Daytona Efecto Perla', '\\assets\\images\\colores\\a4\\blackline\\angulo-a4blackline-gris.webp, \\assets\\images\\colores\\a4\\blackline\\frontal-a4blackline-gris.webp, \\assets\\images\\colores\\a4\\blackline\\lateral-a4blackline-gris.webp, \\assets\\images\\colores\\a4\\blackline\\trasera-a4blackline-gris.webp', 1220, 3),
(26, '\\assets\\images\\colores\\Formentor\\Fr\\imgColor\\circuloBlanco.webp', 'Blanco', '/assets/images/paquetes/cupra/formentor/FR/angulo-formentorfr.png,/assets/images/paquetes/cupra/formentor/FR/lateral-formentorfr.png,/assets/images/paquetes/cupra/formentor/FR/trasera-formentorfr.png', 355, 7),
(27, '\\assets\\images\\colores\\Formentor\\Vz\\imgColor\\circuloBlanco.webp', 'Blanco', '/assets/images/paquetes/cupra/formentor/VZ/angulo.png,/assets/images/paquetes/cupra/formentor/VZ/lateral.png,/assets/images/paquetes/cupra/formentor/VZ/trasera.png', 355, 8),
(28, '\\assets\\images\\colores\\Formentor\\Vz\\imgColor\\circuloGrismetalizado.webp', 'Gris Magnetic', ' \\assets\\images\\colores\\Formentor\\Vz\\formentorVzAngfrente.webp, \\assets\\images\\colores\\Formentor\\Vz\\formentorVzAnglado.webp, \\assets\\images\\colores\\Formentor\\Vz\\formentorVzAngatras.webp', 680, 8),
(29, '\\assets\\images\\colores\\Formentor\\Fr\\imgColor\\circuloNegromidnight.webp', 'Negro Midnight', '\\assets\\images\\colores\\Formentor\\Fr\\FormentorFRanguloadelante.webp, \\assets\\images\\colores\\Formentor\\Fr\\FormentorFRanguloatras.webp, \\assets\\images\\colores\\Formentor\\Fr\\FormentorFRlado.webp', 707, 7),
(30, '\\assets\\images\\colores\\Ateca\\Style\\imgColor\\circuloBlanco.webp', 'Blanco Standard', '/assets/images/paquetes/cupra/ateca/FR/angulo-atecafr.webp,/assets/images/paquetes/cupra/ateca/FR/trasera-atecafr.webp,/assets/images/paquetes/cupra/ateca/FR/lateral-atecafr.webp,', 302, 13),
(31, '\\assets\\images\\colores\\a5\\advance\\imgColor\\circulo-a5advance-negro.webp', 'Negro Brillante', '/assets/images/paquetes/audi/a5/advance/angulo-a5advanced.webp,/assets/images/paquetes/audi/a5/advance/frontal-a5advanced.webp,/assets/images/paquetes/audi/a5/advance/lateral-a5advanced.webp,/assets/images/paquetes/audi/a5/advance/trasera-a5advanced.webp', 655, 5),
(32, '\\assets\\images\\colores\\a5\\advance\\imgColor\\circulo-a5advance-blanco.webp', 'Blanco Glaciar', '\\assets\\images\\colores\\a5\\advance\\angulo-a5-advance-blanco.webp, \\assets\\images\\colores\\a5\\advance\\frontal-a5-advance-blanco.webp, \\assets\\images\\colores\\a5\\advance\\lateral.a5-advance-blanco.webp ,\\assets\\images\\colores\\a5\\advance\\trasera-a5-advance-blanco.webp', 1220, 5),
(33, '\\assets\\images\\colores\\a5\\blackline\\imgColor\\Circulo-a5blackline-verde.webp', 'Verde Distrito Metalizado', '/assets/images/paquetes/audi/a5/Black line edition/angulo-a5black.webp,/assets/images/paquetes/audi/a5/Black line edition/frontal-a5black.webp,/assets/images/paquetes/audi/a5/Black line edition/lateral-a5black.webp,/assets/images/paquetes/audi/a5/Black line edition/trasera-a5black.webp', 780, 6),
(34, '\\assets\\images\\colores\\a5\\blackline\\imgColor\\Circulo-a5blackline-rojo.webp', 'Rojo Progressive', '\\assets\\images\\colores\\a5\\blackline\\angulo-a5blackline-rojo.webp, \\assets\\images\\colores\\a5\\blackline\\frontal-a5blackline-rojo.webp, \\assets\\images\\colores\\a5\\blackline\\lateral-a5blackline-rojo.webp, \\assets\\images\\colores\\a5\\blackline\\trasera-a5blackline-rojo.webp', 1220, 6),
(35, '\\assets\\images\\colores\\Ateca\\Style\\imgColor\\circulodarkcamuflaje.webp', 'Dark Camouflage', '\\assets\\images\\colores\\Ateca\\Style\\atecaStyleAngulo.webp, \\assets\\images\\colores\\Ateca\\Style\\atecaStyleAnguloatras.webp, \\assets\\images\\colores\\Ateca\\Style\\atecaStyleLado.webp', 920, 13),
(36, '\\assets\\images\\colores\\Ateca\\Vz\\imgColor\\circuloGrisMagnetico.webp', 'Gris Metalizado', '/assets/images/paquetes/cupra/ateca/VZ/angulo.png,/assets/images/paquetes/cupra/ateca/VZ/trasera.png,/assets/images/paquetes/cupra/ateca/VZ/lateral-atecavz.webp,', 365, 14),
(37, '\\assets\\images\\colores\\Ateca\\Vz\\imgColor\\circuloBlanconieve.webp', 'Blanco Nevada', '\\assets\\images\\colores\\Ateca\\Vz\\atecaStyleangulodelante.webp, \\assets\\images\\colores\\Ateca\\Vz\\atecaStylelado.webp, \\assets\\images\\colores\\Ateca\\Vz\\atecaStyleanguloatras.webp', 680, 14);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `interior_color`
--

CREATE TABLE `interior_color` (
  `int_color_id` int NOT NULL,
  `int_color_color_image` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `int_color_color` varchar(255) DEFAULT NULL,
  `int_color_image` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `int_color_price` float DEFAULT NULL,
  `fk_package` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `interior_color`
--

INSERT INTO `interior_color` (`int_color_id`, `int_color_color_image`, `int_color_color`, `int_color_image`, `int_color_price`, `fk_package`) VALUES
(1, '/assets/images/tapiceria/a4/sline/circulo-interior-a4-sline.png', 'Negro/Gris', '/assets/images/tapiceria/a4/sline/interior-audia4-sline.png', 0, 3),
(2, '/assets/images/tapiceria/a4/sline/circulo-interior-a4-sline.png', 'Negro/Gris', '/assets/images/tapiceria/golf/life/interior-golf-life.jpg', 0, 1),
(3, '/assets/images/tapiceria/a4/sline/circulo-interior-a4-sline.png\r\n', 'Negro/Gris', '/assets/images/tapiceria/golf/r/interior-golf-r.jpg', 0, 2),
(4, '/assets/images/tapiceria/a4/sline/circulo-interior-a4-sline.png\r\n', 'Negro/Gris', '/assets/images/tapiceria/a4/advanced/interior-a4-advanced.png', 0, 4),
(5, '/assets/images/tapiceria/a4/sline/circulo-interior-a4-sline.png', 'Negro/Gris', '/assets/images/tapiceria/a5/advanced/interior-a5-advanced.png', 0, 5),
(6, '/assets/images/tapiceria/a4/sline/circulo-interior-a4-sline.png', 'Negro/Gris', '/assets/images/tapiceria/a5/blackline/interior-a5-blackline.png', 0, 6),
(7, '/assets/images/tapiceria/formentor/vz/circulo-interior-formentor-vz.png', 'Negro/Gris', '/assets/images/tapiceria/formentor/fr/interior-formentor-fr.jfif', 0, 7),
(8, '/assets/images/tapiceria/formentor/vz/circulo-interior-formentor-vz.png', 'Negro/Gris', '/assets/images/tapiceria/formentor/vz/interior-formentor-vz.jpg', 0, 8),
(9, '/assets/images/tapiceria/a4/sline/circulo-interior-a4-sline.png', 'Negro/Gris', '/assets/images/tapiceria/leon/style/interior-leon-style.jfif', 0, 9),
(10, '/assets/images/tapiceria/leon/fr/circulo-interior-leon-fr.png', 'Negro/Gris', '/assets/images/tapiceria/leon/fr/interior-leon-fr.jfif', 0, 10),
(11, '/assets/images/tapiceria/a4/sline/circulo-interior-a4-sline.png', 'Negro/Gris', '/assets/images/tapiceria/troc/life/interior-troc-life.jpg', 0, 11),
(12, '/assets/images/tapiceria/a4/sline/circulo-interior-a4-sline.png', 'Negro/Gris', '/assets/images/tapiceria/troc/r/interior-troc-r.jpg', 0, 12),
(13, '/assets/images/tapiceria/a4/sline/circulo-interior-a4-sline.png', 'Negro/Gris', '/assets/images/tapiceria/ateca/style/interior-ateca-style.jfif', 0, 13),
(14, '/assets/images/tapiceria/a4/sline/circulo-interior-a4-sline.png', 'Negro/Gris', '/assets/images/tapiceria/ateca/vz/interior-ateca-vz.jfif', 0, 14),
(15, '/assets/images/tapiceria/a4/sline/circulo-interior-a4-sline.png', 'Negro/Gris', '/assets/images/tapiceria/ibiza/style/interior-ibiza-style.jfif', 0, 15),
(16, '/assets/images/tapiceria/a4/sline/circulo-interior-a4-sline.png', 'Negro/Gris', '/assets/images/tapiceria/ibiza/fr/interior-ibiza-fr.jfif', 0, 16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `model`
--

CREATE TABLE `model` (
  `model_id` int NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_of_discharge` date DEFAULT NULL,
  `date_of_termination` date DEFAULT NULL,
  `user_changes` varchar(255) DEFAULT NULL,
  `model_description` varchar(255) DEFAULT NULL,
  `model_emissions` varchar(255) DEFAULT NULL,
  `model_fuel_consumption` varchar(255) DEFAULT NULL,
  `model_image` varchar(255) DEFAULT NULL,
  `model_name` varchar(255) DEFAULT NULL,
  `model_price` varchar(255) DEFAULT NULL,
  `model_status` varchar(255) DEFAULT NULL,
  `brand_model_fk` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `model`
--

INSERT INTO `model` (`model_id`, `date_modified`, `date_of_discharge`, `date_of_termination`, `user_changes`, `model_description`, `model_emissions`, `model_fuel_consumption`, `model_image`, `model_name`, `model_price`, `model_status`, `brand_model_fk`) VALUES
(1, NULL, NULL, NULL, NULL, 'Deportividad versátil\r\nDinamismo, espacio, confort... quédate con todo. El Audi A4 Avant te ofrece más de lo que puedes desear.', '181-129', '8.0-4.9', '/assets/images/modelos/audi/audi-a4.png', 'A4 Avant', '30999', NULL, 1),
(2, NULL, NULL, NULL, NULL, 'El Golf de siempre, renovado', '110-135', '4.2-5.9', '/assets/images/modelos/vw/vw-golf.png', 'Golf', '26990', NULL, 5),
(3, NULL, NULL, NULL, NULL, 'Elegancia deportiva\r\nEl Audi A5 Coupé es la combinación perfecta de deportividad y diseño de vanguardia.', '173–126', '7.7–4.8', '/assets/images/modelos/audi/audi-a5.png', 'A5 Coupé', '38990', NULL, 1),
(4, NULL, NULL, NULL, NULL, 'El primer modelo 100% CUPRA. Un SUV Coupé hecho a medida que te ofrece todo el alto rendimiento de CUPRA.', '169-182', '7.4-8.0', '/assets/images/modelos/cupra/cupra-formentor.png', 'Formentor', '36789', NULL, 7),
(5, NULL, NULL, NULL, NULL, 'Todo un seductor.\r\nConduce de forma más inteligente, con un rendimiento dinámico y un diseño elegante.', '132-143', '5.5-6.3', '/assets/images/modelos/seat/seat-leon.png', 'Leon', '24450', NULL, 8),
(6, NULL, NULL, NULL, NULL, 'Acapararás miradas a tu paso con las luces, colores y acabados del T‑Roc, la apuesta con más carácter de Volkswagen', '122–179', '4.6-7.9', '/assets/images/modelos/vw/vw-troc.png', 'T-Roc', '34599', NULL, 5),
(7, NULL, NULL, NULL, NULL, 'El impulso de los motores de alto rendimiento sumado a la sostenibilidad y facilidad de conducción hacen única tu experiencia en el CUPRA Ateca.', '176-192', '7.7-8.4', '/assets/images/modelos/cupra/cupra-ateca.png', 'Ateca', '46990', NULL, 7),
(8, NULL, NULL, NULL, NULL, 'Sé el alma de la fiesta.\r\n\r\nSube a tus colegas, y la música, y conduce a tu estilSé el alma de la fiesta.\r\n\r\nSube a tus colegas, y la música, y conduce a tu estilo.', '116-126', '6.5-4.1', '/assets/images/modelos/seat/seat-ibiza.png', 'Ibiza', '15590', NULL, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `package`
--

CREATE TABLE `package` (
  `package_id` int NOT NULL,
  `package_bodywork` varchar(255) DEFAULT NULL,
  `package_bumper` varchar(255) DEFAULT NULL,
  `package_description` varchar(255) DEFAULT NULL,
  `package_headlights` varchar(255) DEFAULT NULL,
  `package_image` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `package_name` varchar(255) DEFAULT NULL,
  `package_price` float DEFAULT NULL,
  `package_seats` varchar(255) DEFAULT NULL,
  `fk_model` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `package`
--

INSERT INTO `package` (`package_id`, `package_bodywork`, `package_bumper`, `package_description`, `package_headlights`, `package_image`, `package_name`, `package_price`, `package_seats`, `fk_model`) VALUES
(1, 'Standar', 'Life', 'Asist. salida aparcamiento y cambio carril y sist. aviso p. salir del vehículo,Protección de ocupantes proactiva en combinación con \"Front Assist\" y \"Side Assist\",Control de distancia de aparcamiento \"Park Pilot\" delantero y trasero,Climatronic de 3 zonas', 'LED', '/assets/images/paquetes/vw/golf/Life/life.webp,/assets/images/paquetes/vw/golf/Life/frontal-life.webp,/assets/images/paquetes/vw/golf/Life/lateral-life.webp,/assets/images/paquetes/vw/golf/Life/trasera-life.webp', 'Life', 4263, 'Deportivos Negro Soul ', 2),
(2, 'Aerodinamico Deportivo', 'R-Line', 'Parachoques en color de la carrocería, diseño R-Line, 4 Llantas de aleación ligera \"Valencia\" de 17” en gris metalizado,Moldura entre los faros y las cavidades de la manilla de la puerta iluminadas,Asientos deportivos exclusivos delante', 'LED Matrix ', '/assets/images/paquetes/vw/golf/R/angulo-rline.webp,/assets/images/paquetes/vw/golf/R/frontal-rline.webp,/assets/images/paquetes/vw/golf/R/lateral-rline.webp,/assets/images/paquetes/vw/golf/R/trasero-rline.webp', 'R', 9178, 'ArtVelours', 2),
(3, 'Aerodinamico Deportivo', 'S-Line', 'Llantas de aleación ligera de Audi Sport de 19\",\r\nDiseño estrella de 5 brazos en estrella (8,5J x 19),\r\nNeumáticos 245/35 R 19,\r\nCristales oscurecidos,\r\nCarcasas de los retrovisores en color negro,\r\nBarras longitudinales en el techo de color negro', 'LED Matrix', '/assets/images/paquetes/audi/a4/Black line edition/angulo-audiblack.webp,/assets/images/paquetes/audi/a4/Black line edition/frontal-audiblack.webp,/assets/images/paquetes/audi/a4/Black line edition/lateral-audiblack.webp,/assets/images/paquetes/audi/a4/Black line edition/trasera-audiblack.webp', 'S-Line', 9328, 'Deportivos Frequenz', 1),
(4, 'Standar', 'Advanced', 'Espejos retrovisores calefactables con ajuste eléctrico de posición y plegables eléctricamente con función antideslumbrante,\r\nMarco de las ventanillas en aluminio anodizado,\r\nInserción decorativa en Gris plata,\r\nRevestimiento interior del techo en gris\r', 'LED', '/assets/images/paquetes/audi/a4/Advance/angulo-a4advance.webp,/assets/images/paquetes/audi/a4/Advance/frontal-a4advance.webp,/assets/images/paquetes/audi/a4/Advance/lateral-a4advance.webp,/assets/images/paquetes/audi/a4/Advance/trasera-a4advance.webp', 'Advanced', 5121, 'Deportivos Standar', 1),
(5, 'Standar', 'Advanced', 'Faros LED y pilotos traseros LED,\r\nLlantas de aleación 17\",\r\nRespaldo trasero abatible 40:20:40 con apoyabrazos trasero,\r\nApoyabrazos central delantero de confort,\r\nPaquete de iluminación\r\n', 'LED', '/assets/images/paquetes/audi/a5/advance/angulo-a5advanced.webp,/assets/images/paquetes/audi/a5/advance/frontal-a5advanced.webp,/assets/images/paquetes/audi/a5/advance/lateral-a5advanced.webp,/assets/images/paquetes/audi/a5/advance/trasera-a5advanced.webp', 'Advanced', 5121, 'Deportivos Standar', 3),
(6, 'Aerodinamico Deportivo', 'Black Line Edition', 'Audi parking system trasero,\r\nCarcasas de los retrovisores exteriores en color negro brillante,\r\nCristales traseros tintados oscuros,\r\nCarcasas de los retrovisores exteriores en color negro brillante,\r\nLlantas de aleación Audi Sport de 19\"', 'LED Matrix', '/assets/images/paquetes/audi/a5/Black line edition/angulo-a5black.webp,/assets/images/paquetes/audi/a5/Black line edition/frontal-a5black.webp,/assets/images/paquetes/audi/a5/Black line edition/lateral-a5black.webp,/assets/images/paquetes/audi/a5/Black line edition/trasera-a5black.webp', 'Black Line Edition', 9328, 'Deportivos S-Line', 3),
(7, 'Standar', 'FR', 'Sistema de navegación High,\r\nRetrovisores exteriores eléctricos calefactables plegables eléctricamente y función descenso retrovisor acompañante en aparcamiento\r\nControl por voz,\r\nPilotos traseros LED indicadores animados dirección marcha', 'LED', '/assets/images/paquetes/cupra/formentor/FR/angulo-formentorfr.png,/assets/images/paquetes/cupra/formentor/FR/lateral-formentorfr.png,/assets/images/paquetes/cupra/formentor/FR/trasera-formentorfr.png', 'FR', 4841, 'Bucket', 4),
(8, 'Aerodinamico Deportivo', 'VZ', 'Reposabrazos en consola central con cajón integrado y salidas de aires traseras,\r\nClimatronic (3 zonas) con panel de mandos del climatizador detrás,\r\nElevalunas eléctricos con interruptor confort y limitador de fuerza,\r\nAs. de aparcamiento Park Assist', 'LED Matrix', '/assets/images/paquetes/cupra/formentor/VZ/angulo.png,/assets/images/paquetes/cupra/formentor/VZ/lateral.png,/assets/images/paquetes/cupra/formentor/VZ/trasera.png', 'VZ', 9025, 'CUPBucket', 4),
(9, 'Standar', 'Style', 'Sensor de parking trasero,\r\n 7 Altavoces,\r\nLlantas de aleación Design de 16\" + kit reparapinchazos,\r\n Sistema de arranque sin llave KESSY,\r\nRadio Medio System de 8,25\",\r\nPaquete interior LED: Luces de lectura delanteras y traseras LED con panel táctil', 'LED', '/assets/images/paquetes/seat/Leon/Style/angulo-leonstyle.png, /assets/images/paquetes/seat/Leon/Style/frontal-leonstyle.png, /assets/images/paquetes/seat/Leon/Style/lateral-leonstyle.png, /assets/images/paquetes/seat/Leon/Style/trasera-leonstyle.png', 'Style', 4333, 'Style Standar', 5),
(10, 'Aerodinamico Deportivo', 'FR', 'Cristales traseros oscurecidos,\r\nCargador inalámbrico en consola central, \r\nCuadro de mandos Digital Cockpit 10,25\", \r\nLlantas de aleación 17\" Dynamic, \r\nClimatizador 3 zonas,\r\nAsist. de aparcamiento automático Park Assist,\r\nSensor de parking delantero', 'LED Matrix', '/assets/images/paquetes/seat/Leon/Fr/angulo-leonfr.png,/assets/images/paquetes/seat/Leon/Fr/frontal-leonfr.png,/assets/images/paquetes/seat/Leon/Fr/lateral-leonfr.png,/assets/images/paquetes/seat/Leon/Fr/trasera-leonfr.png', 'FR', 8977, 'FR Dinamica', 5),
(11, 'Standar', 'Life', 'Llantas de aleación \"Johannesburgo\" de 17\",\r\nLunas oscurecidas,\r\nBarras longitudinales negro,\r\nReposabrazos central,\r\nRetrovisores abatibles eléctricamente,\r\nPark Assist,\r\nReady 2 Discover,\r\nApp Connect inalámbrica', 'LED', '/assets/images/paquetes/vw/vw-troc/life/life-troc.webp,/assets/images/paquetes/vw/vw-troc/life/frontal-life-troc.webp,/assets/images/paquetes/vw/vw-troc/life/lateral-life-troc.webp,/assets/images/paquetes/vw/vw-troc/life/trasera-troc-life.webp', 'Life', 4263, 'Negro Titanio Ceramique', 6),
(12, 'Aerodinamico Deportivo', 'R-Line', 'Llantas de aleación \"Nevada\" de 18\",\r\nParachoques de estilo \"R-Line\",\r\nBarras longitudinales plata,\r\nActivación automática de luz de cruce con luz de marcha diurna LED función Coming Home y función Leaving Home,\r\nCámara de visión trasera \"Rear View\"\r\n', 'LED Matrix', '/assets/images/paquetes/vw/vw-troc/r-line/angulo-troc-rline.webp,/assets/images/paquetes/vw/vw-troc/r-line/frontal-rline-troc.webp,/assets/images/paquetes/vw/vw-troc/r-line/lateral-rline-troc.webp,/assets/images/paquetes/vw/vw-troc/r-line/trasera-rline-troc.webp', 'R-Line', 9378, 'Soul Gris Silex', 6),
(13, 'Standar', 'Style', 'Faros antiniebla,\r\nFaros principales LED con lente,\r\nPilotos traseros LED indicadores animados dirección marcha,\r\nLunas laterales antitérmicas a partir del montante B y detrás en cristal de color oscuro,\r\nBarras longitudinales del techo negro', 'LED', '/assets/images/paquetes/cupra/ateca/FR/angulo-atecafr.webp,/assets/images/paquetes/cupra/ateca/FR/trasera-atecafr.webp,/assets/images/paquetes/cupra/ateca/FR/lateral-atecafr.webp,', 'Style', 4788, 'Bucket Dinamica', 7),
(14, 'Aerodinamico Deportivo', 'VZ', 'Tracción a las cuatro ruedas,\r\nReposabrazos central delante,\r\nEspejo de cortesía a la izquierda iluminado con tapa y bolsillo,\r\nRetrovisor interior de seguridad con ajuste automático de posición antideslumbrante,\r\nTecho moldeado en una pieza', 'LED Matrix', '/assets/images/paquetes/cupra/ateca/VZ/angulo.png,/assets/images/paquetes/cupra/ateca/VZ/trasera.png,/assets/images/paquetes/cupra/ateca/VZ/lateral-atecavz.webp,', 'VZ', 9199, 'Bucket Piel', 7),
(15, 'Standar', 'Style', 'Faros Full LED delanteros y traseros,\r\nControl de velocidad de crucero,\r\nFull Link (Android Auto & Car Play),\r\nLlantas de aleación de 38cm (15\"),\r\nLuces antiniebla delanteras con función cornering\r\n', 'LED', '/assets/images/paquetes/seat/Ibiza/style/angulo-ibizastyle.png,/assets/images/paquetes/seat/Ibiza/style/frontal-ibizastyle.png,/assets/images/paquetes/seat/Ibiza/style/lateral-ibizastyle.png,/assets/images/paquetes/seat/Ibiza/style/trasera-ibizastyle.png', 'Style', 4335, 'Style Standar', 8),
(16, 'Aerodinamico Deportivo', 'FR', 'Parachoques específico FR,\r\nSuspensión específica FR,\r\nIluminación ambiental,\r\nLlantas de aleación Dynamic 17\",\r\nClimatizador automático bizona,\r\nSEAT Drive Profile: selector de modos de conducción', 'LED Matrix', '/assets/images/paquetes/seat/Ibiza/fr/angulo-ibizafr.png,/assets/images/paquetes/seat/Ibiza/fr/frontal-ibizafr.png,/assets/images/paquetes/seat/Ibiza/fr/lateral-ibizafr.png,/assets/images/paquetes/seat/Ibiza/fr/trasera-ibizafr.png', 'FR', 8989, 'FR Luxe', 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tire`
--

CREATE TABLE `tire` (
  `tire_id` int NOT NULL,
  `tire_circulo` varchar(255) DEFAULT NULL,
  `tire_color` varchar(255) DEFAULT NULL,
  `tire_description` varchar(255) DEFAULT NULL,
  `tire_image` varchar(255) DEFAULT NULL,
  `tire_inches` int DEFAULT NULL,
  `tire_material` varchar(255) DEFAULT NULL,
  `tire_name` varchar(255) DEFAULT NULL,
  `tire_price` float DEFAULT NULL,
  `fk_package` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_table`
--

CREATE TABLE `user_table` (
  `user_id` int NOT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_birthday` varchar(255) DEFAULT NULL,
  `user_country` varchar(255) DEFAULT NULL,
  `user_dni` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_first_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_phone` varchar(255) DEFAULT NULL,
  `user_province` varchar(255) DEFAULT NULL,
  `registration_date` datetime(6) DEFAULT NULL,
  `user_rol` varchar(255) DEFAULT NULL,
  `user_second_last_name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `user_table`
--

INSERT INTO `user_table` (`user_id`, `user_address`, `user_birthday`, `user_country`, `user_dni`, `user_email`, `user_first_name`, `user_password`, `user_phone`, `user_province`, `registration_date`, `user_rol`, `user_second_last_name`, `username`) VALUES
(13, NULL, NULL, NULL, NULL, 'daniramosm.06@gmail.com', 'daniel', '$2a$10$L6wH8PxrHe3Ki.3J8vEX/ulbO2USEBYvsBIRUrWbF1F3bjsReOxdS', NULL, NULL, '2024-02-02 08:15:31.301000', 'ROLE_USER', 'ramos', NULL),
(14, NULL, NULL, NULL, NULL, 'alvaro@gmail.com', 'Alvaro', '$2a$10$aiH8nDGsXfyEaUXhOwLZFeLvhSi6kZIX3SIjP3LDP3wfv3Gd7gSZ2', NULL, NULL, '2024-02-02 11:37:47.323000', 'ROLE_USER', 'cedazo', NULL),
(15, NULL, NULL, NULL, NULL, 'vicente.santiagop@viewnext.com', 'Vicente', '$2a$10$dMiH5jWV1eRDp0T3wBUNNe84F..b2LFBIuUBLZB23C3Pkfnv8UjG2', NULL, NULL, '2024-02-05 12:48:34.523000', 'ROLE_USER', 'Pepe', NULL),
(16, NULL, NULL, NULL, NULL, 'pepealb@gmaqil.com', 'Vicente', '$2a$10$ENR8Kgokcq.784S6d0B/Fu2.DG3.T4YvmQCNQb1B3yS8uyJErNx1W', NULL, NULL, '2024-02-05 13:03:05.525000', 'ROLE_USER', 'wege', NULL),
(17, NULL, NULL, NULL, NULL, 'lucas@gmail.com', 'lucas', '$2a$10$FOupxd2oRCPBIT2wqyHMjuAGdfiYqHhffzzwYUsN1zoGctYdyn5wW', NULL, NULL, '2024-02-06 09:03:33.657000', 'ROLE_USER', 'herrero', NULL),
(18, NULL, NULL, NULL, NULL, 'lucasherrero2010@hotmail.com', 'Lucas', '$2a$10$dQZpDfKQrZG.NLTSk.5tPuiS7tx6981SoxPN8WPzry0pvR8nBiSqW', NULL, NULL, '2024-02-07 13:19:59.822000', 'ROLE_USER', 'Herrrero', NULL),
(19, NULL, NULL, NULL, NULL, 'julia.lopez@viewnext.com', 'Julia', '$2a$10$ZxAnUT7zKxgEn/IRFBtXbu0gzsbi1FjuBGQJjY066lIBX1nSx2Ie6', NULL, NULL, '2024-02-13 13:13:08.723000', 'ROLE_USER', 'López', NULL),
(27, NULL, NULL, NULL, NULL, 'vicen@vicen.comwef', 'Vicente', '$2a$10$i/JDVP4tl2Mpso8m14eyOetXFtO9tknRJedyU1FxOsBnMwm8B3e8W', NULL, NULL, '2024-02-14 09:48:37.643000', 'ROLE_USER', 'Pepe', NULL),
(30, NULL, NULL, NULL, NULL, 'vicen@vicen.com', 'Vicente', '$2a$10$.IW22na2CfCM.hpMvJypbO2H2P0ColJtVTMWMW7R4a/CUFioc/oPC', NULL, NULL, '2024-02-14 11:25:24.050000', 'ROLE_USER', 'Santiago', NULL),
(38, NULL, NULL, NULL, NULL, 'lucas@hotmail.com', 'Lucas', '$2a$10$IYJmgz74A70vKSDvOciwmOiVMJ0SMNLSh2oTLUQ4fujy/jpdpBiBG', NULL, NULL, '2024-02-15 12:40:51.058000', 'ROLE_USER', 'Herrrero', NULL),
(45, NULL, NULL, NULL, NULL, 'qwqd@gm', 'Pepe', '$2a$10$GKjAqrrW6DKidQ0aosXhWu9VK58ov8yv3f2txAdXGFdyK9ZuCjhFe', NULL, NULL, '2024-02-19 08:35:11.335000', 'ROLE_USER', 'wege', NULL),
(46, NULL, NULL, NULL, NULL, 'pepealb@gmail.com', 'Juan', '$2a$10$gM8HoGLSrOGPHAzkzm8EPOeCVDAkXOVIPAso/BSL2nqNB/n/pgHQi', NULL, NULL, '2024-02-19 08:35:48.036000', 'ROLE_USER', 'wege', NULL),
(47, NULL, NULL, NULL, NULL, 'pepea12lb@gmail.com', 'Vicente', '$2a$10$YOZsTmrDyvq.HUyAV1ASQeysQ0EjOpDf.L51NrJf/G4YduujJxBh6', NULL, NULL, '2024-02-19 08:40:40.813000', 'ROLE_USER', 'Pepe', NULL),
(48, NULL, NULL, NULL, NULL, 'vicencodhd@gmail.com', 'Vicen', '$2a$10$H72U.o37FCIkGskr121Fy.MUgtzw.UnlshNvCmdNsvbtqAIOqDAX6', NULL, NULL, '2024-02-21 11:43:12.419000', 'ROLE_USER', 'Santiago', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `appoinments`
--
ALTER TABLE `appoinments`
  ADD PRIMARY KEY (`appoinment_id`),
  ADD KEY `FK9glf8weu85j9rs785ik73q39q` (`appoinment_car`);

--
-- Indices de la tabla `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`brand_id`);

--
-- Indices de la tabla `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`car_id`),
  ADD KEY `FKj1mws2ruu9q6k2sa4pwlxthxn` (`brand_id`),
  ADD KEY `FK7qsah3n0ggngs724edvx982of` (`car_engine_id`),
  ADD KEY `FKq6l7hmmuq7fe9bqm7813jt8w2` (`ext_color_id`),
  ADD KEY `FKqc3q7f1qy3c10icqiukydybxd` (`int_color_id`),
  ADD KEY `FK772uqy9hm5yicyxh9t6x6vusr` (`model_id`),
  ADD KEY `FK22wu7fagqv994qgef5g72gcl4` (`package_id`),
  ADD KEY `FK5nnlhnefbu5f67lq71egm0spy` (`tire_id`),
  ADD KEY `FKd02ce86s9xwlnfnmxgxr22p58` (`user_id`);

--
-- Indices de la tabla `car_engine`
--
ALTER TABLE `car_engine`
  ADD PRIMARY KEY (`car_engine_id`),
  ADD KEY `FKidsemage9wncqiufwibuee01l` (`fk_model`);

--
-- Indices de la tabla `exterior_color`
--
ALTER TABLE `exterior_color`
  ADD PRIMARY KEY (`ext_color_id`),
  ADD KEY `FKavmma3bp3m8fjnybbg5n5kl5a` (`fk_package`);

--
-- Indices de la tabla `interior_color`
--
ALTER TABLE `interior_color`
  ADD PRIMARY KEY (`int_color_id`),
  ADD KEY `FK28jpop2amplofrd40asayl57k` (`fk_package`);

--
-- Indices de la tabla `model`
--
ALTER TABLE `model`
  ADD PRIMARY KEY (`model_id`),
  ADD KEY `FKog08rgarn125yf63xflmkyxas` (`brand_model_fk`);

--
-- Indices de la tabla `package`
--
ALTER TABLE `package`
  ADD PRIMARY KEY (`package_id`),
  ADD KEY `FKf6blvdouw8wtd9fx9klbhlhie` (`fk_model`);

--
-- Indices de la tabla `tire`
--
ALTER TABLE `tire`
  ADD PRIMARY KEY (`tire_id`),
  ADD KEY `FKeyd4uoro3l8toxdomm2bydycs` (`fk_package`);

--
-- Indices de la tabla `user_table`
--
ALTER TABLE `user_table`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UK_3hf978639x2nc5pudx71rwywe` (`user_email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `appoinments`
--
ALTER TABLE `appoinments`
  MODIFY `appoinment_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `brand`
--
ALTER TABLE `brand`
  MODIFY `brand_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `car`
--
ALTER TABLE `car`
  MODIFY `car_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `car_engine`
--
ALTER TABLE `car_engine`
  MODIFY `car_engine_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `exterior_color`
--
ALTER TABLE `exterior_color`
  MODIFY `ext_color_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT de la tabla `interior_color`
--
ALTER TABLE `interior_color`
  MODIFY `int_color_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `model`
--
ALTER TABLE `model`
  MODIFY `model_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `package`
--
ALTER TABLE `package`
  MODIFY `package_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `tire`
--
ALTER TABLE `tire`
  MODIFY `tire_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `user_table`
--
ALTER TABLE `user_table`
  MODIFY `user_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `appoinments`
--
ALTER TABLE `appoinments`
  ADD CONSTRAINT `FK9glf8weu85j9rs785ik73q39q` FOREIGN KEY (`appoinment_car`) REFERENCES `car` (`car_id`);

--
-- Filtros para la tabla `car`
--
ALTER TABLE `car`
  ADD CONSTRAINT `FK22wu7fagqv994qgef5g72gcl4` FOREIGN KEY (`package_id`) REFERENCES `package` (`package_id`),
  ADD CONSTRAINT `FK5nnlhnefbu5f67lq71egm0spy` FOREIGN KEY (`tire_id`) REFERENCES `tire` (`tire_id`),
  ADD CONSTRAINT `FK772uqy9hm5yicyxh9t6x6vusr` FOREIGN KEY (`model_id`) REFERENCES `model` (`model_id`),
  ADD CONSTRAINT `FK7qsah3n0ggngs724edvx982of` FOREIGN KEY (`car_engine_id`) REFERENCES `car_engine` (`car_engine_id`),
  ADD CONSTRAINT `FKd02ce86s9xwlnfnmxgxr22p58` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`user_id`),
  ADD CONSTRAINT `FKj1mws2ruu9q6k2sa4pwlxthxn` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`brand_id`),
  ADD CONSTRAINT `FKq6l7hmmuq7fe9bqm7813jt8w2` FOREIGN KEY (`ext_color_id`) REFERENCES `exterior_color` (`ext_color_id`),
  ADD CONSTRAINT `FKqc3q7f1qy3c10icqiukydybxd` FOREIGN KEY (`int_color_id`) REFERENCES `interior_color` (`int_color_id`);

--
-- Filtros para la tabla `car_engine`
--
ALTER TABLE `car_engine`
  ADD CONSTRAINT `FKidsemage9wncqiufwibuee01l` FOREIGN KEY (`fk_model`) REFERENCES `model` (`model_id`);

--
-- Filtros para la tabla `exterior_color`
--
ALTER TABLE `exterior_color`
  ADD CONSTRAINT `FKavmma3bp3m8fjnybbg5n5kl5a` FOREIGN KEY (`fk_package`) REFERENCES `package` (`package_id`);

--
-- Filtros para la tabla `interior_color`
--
ALTER TABLE `interior_color`
  ADD CONSTRAINT `FK28jpop2amplofrd40asayl57k` FOREIGN KEY (`fk_package`) REFERENCES `package` (`package_id`);

--
-- Filtros para la tabla `model`
--
ALTER TABLE `model`
  ADD CONSTRAINT `FKog08rgarn125yf63xflmkyxas` FOREIGN KEY (`brand_model_fk`) REFERENCES `brand` (`brand_id`);

--
-- Filtros para la tabla `package`
--
ALTER TABLE `package`
  ADD CONSTRAINT `FKf6blvdouw8wtd9fx9klbhlhie` FOREIGN KEY (`fk_model`) REFERENCES `model` (`model_id`);

--
-- Filtros para la tabla `tire`
--
ALTER TABLE `tire`
  ADD CONSTRAINT `FKeyd4uoro3l8toxdomm2bydycs` FOREIGN KEY (`fk_package`) REFERENCES `package` (`package_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
