# Data Engineering Portfolio – Scala & PySpark (EOI)

This repository contains my **Data Engineering Portfolio**, developed as part of the **Master’s Degree in Data Engineering at EOI**, using **Scala** and **PySpark**.

The purpose of this portfolio is to document my progressive learning journey, from foundational concepts to practical exercises and more structured examples.

---

## Academic Context

**Master’s Degree:** Data Engineering  
**Module:** Functional Programming, Scala & PySpark  
**Institution:** EOI – Escuela de Organización Industrial

This repository is based on both theoretical and practical concepts covered during the module, including:

- Functional Programming (FP)
- Pure functions & immutability
- Usage of `val`, `var`, and `def`
- Anonymous functions (lambdas)
- Higher-Order Functions (HOF)
- Currying & partially applied functions
- Collections (List, Seq, Tuple)

### Functional error handling:
- `Option`
- `Try`
- `Either`

Additional Scala concepts:
- Traits & mixins
- Generics
- Functional validations
- Scala as a hybrid language (FP + OOP)


### Spark & PySpark (later weeks)
- Spark basics & execution model
- Transformations & actions
- Spark SQL fundamentals
- Introduction to PySpark

---

## Repository Contents

### **Week 1 – Scala Fundamentals & Functional Programming**

This first stage focuses on the core Scala concepts, building the foundation for later Spark and PySpark work.

### Topics Covered

✔ Basic Scala syntax  
✔ Functions (`def`)  
✔ Anonymous functions (lambdas)  
✔ Higher-Order Functions  
✔ Collections (`List`, `map`, `filter`, `reduce`)  
✔ Functional error handling  
✔ Traits  
✔ Generics  
✔ Functional validations

---

### Exercises Implemented

- **Semana1_Portfolio.scala** → Introductory Scala program
- **FuncionesBasicas.scala** → Named functions & lambdas
- **FuncionesOrdenSuperior.scala** → Higher-Order Functions
- **OptionBasico.scala** → Safe value handling
- **TryBasico.scala** → Exception handling
- **EitherValidacion.scala** → Functional error modeling
- **ColeccionesBasicas.scala** → `map` / `filter` / `reduce`
- **ValidacionesCorreo.scala** → Functional validations
- **GenericsBasico.scala** → Type parameters
- **NotasConTraitsApp.scala** → Traits + Collections + FP

---

## Mini Project – IoT Data Validator

A structured example simulating:

✔ Sensor data generation  
✔ Domain modeling  
✔ Functional validations  
✔ Valid vs invalid data partitioning  
✔ Error reporting  
✔ Basic execution time measurement

### Files:
- `IotDomain.scala`
- `IotDataValidations.scala`
- `IotDataValidatorApp.scala`

---

## Week 2 – Spark (Local) + Spark SQL Intro
This stage focuses on running **Apache Spark locally** using **Scala + IntelliJ**, and practicing **Spark Core** and **Spark SQL**.

### What I worked on
✔ Spark setup and execution in **IntelliJ** (local mode)  
✔ Creating a `SparkSession` and running jobs with `local[*]`  
✔ Understanding basic Spark app lifecycle (driver/executor locally)  
✔ Spark UI access in local mode (port 4040)  
✔ Spark SQL + DataFrame operations  
✔ Reading JSON files from `src/main/resources`  
✔ Building a helper (`SqlRunner`) to label SQL jobs in Spark UI/logs

### Exercises Implemented

#### 1) SparkPi (Spark Core)
Classic Spark example to compute an approximation of π, reinforcing:
- Parallelization
- Transformations vs actions
- Local execution with Spark

 `src/main/scala/portfolio/week2/SparkPi.scala`

#### 2) Spark SQL Intro 01 – JSON Input from resources
Spark SQL basics using a sample JSON file stored in resources:
- Load JSON into a DataFrame
- Print schema & show data
- Create temp view and query with SQL

`src/main/scala/portfolio/week2/sqlintro/SparkSQLIntro01.scala`  
`src/main/resources/sample_data/employees.json`

> Note: I created the resources folder and stored the JSON under:
> `src/main/resources/sample_data/`

#### 3) SqlRunner Example – “SQL job labeling” + queries
A small helper that executes SQL strings and sets metadata:
- `callSite.short`
- `callSite.long`
- Job description (visible in Spark UI)

It runs multiple SQL queries over a registered temp view and compares with the DataFrame API.

`src/main/scala/portfolio/week2/sqlintro/SqlRunnerExample.scala`

Key learning:
- Avoiding encoder errors by modeling optional values with `Option`
- Practical use of temp views + SQL strings
- Improving traceability of jobs inside Spark UI

---

## Technologies Used
- Scala
- Apache Spark
- PySpark (later weeks)
- sbt
- Java (Eclipse Temurin)
- IntelliJ IDEA
- Git & GitHub

---

## Notebooks (Jupyter / Almond)
Some weeks may include notebooks using:
- Jupyter + Scala (Almond)

Used for:
✔ Theoretical explanations  
✔ Interactive exercises  
✔ Learning documentation

They will be added progressively.

---

## Note
This repository has an educational and academic purpose, representing a progressive learning process within the Master’s Degree in Data Engineering.

---

## Author
**Marla Marie Lluberes Santana**  
Industrial Engineer  
EOI – Master’s Degree in Data Engineering

---

## Project Status
**In Development – Updated weekly.**