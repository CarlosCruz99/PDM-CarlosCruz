package com.example.ejercicios

import kotlin.collections.filter

data class Computadora (var RAM: Int, var almacenamiento: String, var sistemaOperativo: String, var programasInstalados: List<String>) {
    fun encender() {
        println("La computadora esta encendida")
    }

    fun apagar() {
        println("La computadora esta apagada")
    }

    fun actualizarComponentes() {
        var nuevaRAM: Int; var nuevoAlmacenamiento: String; var nuevoSistemaOperativo: String
        println("Ingrese la nueva RAM:")
        nuevaRAM=readln().toInt()
        println("Ingrese el nuevo almacenamiento: (Ejemplo: 256 GB SSD)")
        nuevoAlmacenamiento=readln()
        println("Ingrese el nuevo sistema operativo:")
        nuevoSistemaOperativo=readln()
        RAM=nuevaRAM
        almacenamiento=nuevoAlmacenamiento
        sistemaOperativo=nuevoSistemaOperativo
        println("Se han actualizado los componentes de la computadora")
    }

    fun mostrarProgramasInstalados(){
        var programasInstaladosAnioActual=programasInstalados.filter{it.contains("2026")}
        programasInstaladosAnioActual.forEach{
            println(it)
        }
    }
}

data class Calculadora (val marca: String, val aniosDeVida: Int, var precio: Float){
        fun sumar(a: Double, b: Double) {
            println("Resultado: "+(a + b))
        }

        fun restar(a: Double, b: Double) {
            println("Resultado: "+(a - b))
        }

        fun multiplicar(a: Double, b: Double) {
            println("Resultado: "+(a * b))
        }

        fun dividir(a: Double, b: Double) {
            if ((a / b).toString() == "NaN" || (a / b).toString() == "Infinity") {
                println("Ha ocurrido un error: Division entre 0")
            } else {
                println("Resultado: "+(a / b))
            }
        }
}

data class Estudiante (val nombreEstudiante: String, val carnet: String, var asignatura: String)

fun crearComputadora(): Computadora {
    var RAM: Int
    var almacenamiento: String
    var sistemaOperativo: String
    var programasInstalados = listOf("Notion 2026", "Facebook 2024", "Whatsapp 2009", "Office 2026", "Steam 2003")
    println("Ingresa los datos de la computadora:\n"
            +"RAM:")
    RAM=readln().toInt()
    println("Almacenamiento: (Ejemplo: 256 GB SSD)")
    almacenamiento=readln()
    println("Sistema operativo:")
    sistemaOperativo=readln()
    return Computadora(RAM, almacenamiento, sistemaOperativo, programasInstalados)
}
fun crearCalculadora(): Calculadora {
    var marca: String
    var aniosDeVida: Int
    var precio: Float
    println("Ingresa los datos de la calculadora:\n"
            +"Marca:")
    marca=readln()
    println("Anios de vida:")
    aniosDeVida=readln().toInt()
    println("Precio:")
    precio=readln().toFloat()
    return Calculadora (marca, aniosDeVida, precio)
}

fun funcionesComputadora(computadora: Computadora){
    var funcion=0

    do{
        try{
            println("Digita el numero de la funcion que deseas ocupar:\n"
                    +"1: Encender (una vez encendida se pueden observar los programas instalados)\n"
                    +"2: Actualizar componentes de la computadora\n"
                    +"3: Apagar la computadora (Salir de la computadora)")
            funcion=readln().toInt()
            when(funcion){
                1->{
                    var funcionComputadora=0
                    computadora.encender()
                    do{
                        println("Digita el numero de la funcion que deseas ocupar:\n"
                                +"1: Ver programas instalados con la fecha de este anio\n"
                                +"2: Apagar la computadora")
                        funcionComputadora=readln().toInt()
                        when(funcionComputadora){
                            1->computadora.mostrarProgramasInstalados()
                            2->{
                                computadora.apagar()
                                break
                            }
                            else->println("Ingrese un numero de los que se encuentra en la lista")
                        }
                    } while (funcionComputadora!=2)
                }
                2->computadora.actualizarComponentes()
                3->{
                    computadora.apagar()
                    break
                }
                else->println("Ingrese un numero de los que se encuentra en la lista")
            }
        }
        catch (e: Exception){
            println("Ingrese un numero valido")
        }

    } while (funcion!=3)
}
fun funcionesCalculadora(calculadora: Calculadora){
    var operacion=0; var a=0.0; var b=0.0

    do{
        try{
            println("Digita el numero de la operacion que deseas realizar:\n"
                    +"1: Sumar (a+b)\n"
                    +"2: Restar (a-b)\n"
                    +"3: Multiplicar (a*b)\n"
                    +"4: Dividir (a/b)")
            operacion=readln().toInt()
            println("Digita el valor de 'a':")
            a=readln().toDouble()
            println("Digita el valor de 'b':")
            b=readln().toDouble()
            when(operacion){
                1->calculadora.sumar(a, b)
                2->calculadora.restar(a, b)
                3->calculadora.multiplicar(a, b)
                4->calculadora.dividir(a, b)
                else->println("Ingrese un numero de los que se encuentra en la lista")
            }
        }
        catch (e: Exception){
            println("Ingrese un numero valido")
        }

    } while (operacion<1||operacion>4)
}
fun filtrarPorAsignatura(listaEstudiantes: List<Estudiante>){
    var asignatura=0
    var estudiantesFiltrados=listaEstudiantes

    do{
        try{
            println("Digita el numero de la asignatura para filtrar a los estudiantes:\n"
                    +"1: Programacion de dispositivos moviles\n"
                    +"2: Analisis numerico")
            asignatura=readln().toInt()
            when(asignatura){
                1->estudiantesFiltrados=listaEstudiantes.filter{it.asignatura=="PDM"}
                2->estudiantesFiltrados=listaEstudiantes.filter{it.asignatura=="Analisis numerico"}
                else->println("Ingrese un numero de los que se encuentra en la lista")
            }
        }
        catch (e: Exception){
            println("Ingrese un numero valido")
        }

    } while (asignatura<1||asignatura>2)

    estudiantesFiltrados.forEach{
        println("Nombre: "+it.nombreEstudiante+" | Carnet: "+it.carnet)
    }
}

fun seleccionDeEjercicio(Ciclo01: List<Estudiante>){
    var ejercicio=0

    do{
        try{
            println("Digita el numero del ejercicio al que deseas acceder:\n"
                    +"1: Computadora\n"
                    +"2: Calculadora\n"
                    +"3: Lista de estudiantes\n"
                    +"4: Salir del programa")
            ejercicio=readln().toInt()
            when(ejercicio){
                1->{
                    val computadora=crearComputadora()
                    funcionesComputadora(computadora)
                }
                2->{
                    val calculadora=crearCalculadora()
                    funcionesCalculadora(calculadora)
                }
                3->filtrarPorAsignatura(Ciclo01)
                4->break
                else->println("Ingrese un numero de los que se encuentra en la lista")
            }
        }
        catch (e: Exception){
            println("Ingrese un numero valido")
        }

    } while (ejercicio!=4)
}