


/* ID ALEATORIO SEGUIDO DE ESTA REPETIDO*/

				Random rand = new Random();
				int idGenerado = -1;
				do {
				    idGenerado = rand.nextInt(rango) + valorMinimo;
				} while (estaRepetido(lista, idGenerado));
				this.id = idGenerado;
				
				
				private boolean estaRepetido(ArrayList<MiClase> lista, int idGenerado) {
				    for (int i = 0; i < lista.size(); i++) {
				        if (lista.get(i).getId() == idGenerado) {
				            return true;
				        }
				    }
				    return false;
				}
				
				
/* ID MANUAL*/
				
				
				do {
				    idUsuario = Integer.parseInt(leer.readLine());
				    if (idUsuario < 1 || idUsuario > 1025)
				        System.out.println("Tiene que ser entre 1 y 1025");
				} while (estaRepetido(lista, idUsuario) || idUsuario < 1 || idUsuario > 1025); //EJEMPLO POKEDES POKEMON
				
				
				private boolean estaRepetido(ArrayList<MiClase> lista, int idGenerado) {
				    for (int i = 0; i < lista.size(); i++) {
				        if (lista.get(i).getId() == idGenerado) {
				            return true;
				        }
				    }
				    return false;
				}
				
				
				
/* MOSTRAR TODO CLASE PADRE */
				
				
				
				private static void mostrarTodos(ArrayList<MiClase> lista) {
				    if (lista.size() == 0) {
				        System.out.println("No hay elementos registrados");
				        return;
				    }
				    for (MiClase objeto : lista) {
				        objeto.mostrarDatos();
				    }
				}
				
/* MOSTRAR TODO CLASE PADRE CON ATRIBUTO ESPECIFICO */
				
				private static void mostrarPorTipo(ArrayList<MiClase> lista) {
				    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
				    String tipo = "";
				    do {
				        try {
				            System.out.print("Introduce el tipo (opcion1/opcion2): ");
				            tipo = leer.readLine();
				            if (!tipo.equalsIgnoreCase("opcion1") && !tipo.equalsIgnoreCase("opcion2"))
				                System.out.println("Tipo no valido");
				        } catch (IOException e) {
				            System.err.println("Error leyendo datos");
				        }
				    } while (!tipo.equalsIgnoreCase("opcion1") && !tipo.equalsIgnoreCase("opcion2"));

				    boolean enc = false;
				    for (MiClase objeto : lista) {
				        if (objeto.getTipo().equalsIgnoreCase(tipo)) {
				            objeto.mostrarDatos();
				            enc = true;
				        }
				    }

				    if (!enc)
				        System.out.println("No hay elementos de ese tipo");
				}
				
				
/* MOSTRAR TODO CLASE HIJA */
				
				for (Deportista d : lista) {
				    if (d instanceof Futbolista) {
				        d.mostrarDatos();
				    }
				}
				
				
/* MOSTRAR TODO CLASE HIJA CON ATRIBUTO ESPECIFICO*/
	
				// por ejemplo filtrar futbolistas por equipo, equipo es atributo del hijo
				for (Deportista d : lista) {
				    if (d instanceof Futbolista) {
				        if (((Futbolista) d).getEquipo().equalsIgnoreCase(equipo)) {
				            d.mostrarDatos();
				        }
				    }
				}
				
				
/* EJEMPLOS SUPER */
				
				//Persona.java (abuelo)
				protected void pedirDatos(ArrayList<Deportista> lista) {
				    System.out.print("Introduce el nombre: ");
				    nombre = leer.readLine();
				    System.out.print("Introduce la edad: ");
				    edad = Integer.parseInt(leer.readLine());
				}

				protected void mostrarDatos() {
				    System.out.println("Nombre: " + nombre);
				    System.out.println("Edad: " + edad);
				}
				
				
				//Deportista.java (padre)
				protected void pedirDatos(ArrayList<Deportista> lista) {
				    super.pedirDatos(lista); // pide nombre y edad de Persona
				    System.out.print("Introduce el deporte: ");
				    deporte = leer.readLine();
				}

				protected void mostrarDatos() {
				    super.mostrarDatos(); // muestra nombre y edad de Persona
				    System.out.println("Deporte: " + deporte);
				}
				
				
				//Futbolista.java (hijo)
				public void pedirDatos(ArrayList<Deportista> lista) {
				    super.pedirDatos(lista); // pide nombre, edad Y deporte de Deportista
				    System.out.print("Introduce el equipo: ");
				    equipo = leer.readLine();
				}

				public void mostrarDatos() {
				    super.mostrarDatos(); // muestra nombre, edad Y deporte de Deportista
				    System.out.println("Equipo: " + equipo);
				}
				
				Cuando llamas a `futbolista.mostrarDatos()` por pantalla sale todo en cadena:
					```
					Nombre: Juan        ← viene de Persona
					Edad: 25            ← viene de Persona
					Deporte: Futbol     ← viene de Deportista
					Equipo: Real Madrid ← viene de Futbolista
					
					
/* SUPER CON CONSTRUCTOR (EN VEZ DE PEDIR DATOS) */
					
					
					//Paciente.java (padre)
					public class Paciente {
					    private int id;
					    private String nombre;
					    private int edad;

					    public Paciente(int id, String nombre, int edad) {
					        this.id = id;
					        this.nombre = nombre;
					        this.edad = edad;
					    }

					    public void mostrarDatos() {
					        System.out.println("ID: " + this.id);
					        System.out.println("Nombre: " + this.nombre);
					        System.out.println("Edad: " + this.edad);
					    }
					}
				
				
				 	//PacienteUrgencias.java (hijo)
					public class PacienteUrgencias extends Paciente {
					    private int gravedad;
	
					    public PacienteUrgencias(int id, String nombre, int edad, int gravedad) {
					        super(id, nombre, edad); // llama al constructor del padre
					        this.gravedad = gravedad;
					    }
	
					    public void mostrarDatos() {
					        super.mostrarDatos(); // muestra los datos del padre
					        System.out.println("Gravedad: " + this.gravedad);
					    }
					}
					
					//Principal.java
					PacienteUrgencias p = new PacienteUrgencias(1, "Juan", 30, 3);
					p.mostrarDatos();
					
					//la validacion se debe de hacer antes de crear el constructor en principal (se hace en el propio principal)
					// en Principal, antes de crear el objeto
					int gravedad = -1;
					do {
					    try {
					        System.out.print("Introduce la gravedad (1-5): ");
					        gravedad = Integer.parseInt(leer.readLine());
					        if (gravedad < 1 || gravedad > 5)
					            System.out.println("Tiene que ser entre 1 y 5");
					    } catch (NumberFormatException | IOException e) {
					        System.out.println("Solo numeros");
					        gravedad = -1;
					    }
					} while (gravedad < 1 || gravedad > 5);

					// una vez validado, creas el objeto
					PacienteUrgencias p = new PacienteUrgencias(id, nombre, edad, gravedad);
					
					
					//Lo que CAMBIA con constructores:
						// en vez de esto
						Paciente p = new Paciente();
						p.pedirDatos(lista);

						// haces esto (validas antes y pasas los datos)
						String nombre = // pides y validas en Principal
						int edad = // pides y validas en Principal
						Paciente p = new PacienteUrgencias(id, nombre, edad, gravedad);
						
						
						//Lo que NO CAMBIA nunca:
							// mostrar siempre igual
							for (Paciente p : lista) {
							    if (p instanceof PacienteUrgencias) {
							        p.mostrarDatos();
							    }
							}

							// y en la clase hijo siempre igual
							public void mostrarDatos() {
							    super.mostrarDatos();
							    System.out.println("Gravedad: " + gravedad);
							}
							
							
							char opcion = ' ';
							boolean datosOK = false;
							while (!datosOK) {
							    try {
							        System.out.print("Introduce una opcion: ");
							        String entrada = leer.readLine();
							        if (entrada.length() > 0) {
							            opcion = entrada.toUpperCase().charAt(0);
							            datosOK = true;
							        } else {
							            System.out.println("Introduce una letra valida");
							        }
							    } catch (IOException e) {
							        System.out.println("Error leyendo datos");
							    }
							}

							// y el switch con letras
							switch (opcion) {
							    case 'A':
							        añadirPersonaje(personajes);
							        break;
							    case 'B':
							        mostrarPorBando(personajes);
							        break;
							    case 'C':
							        añadirAlEquipo(personajes);
							        break;
							    case 'D':
							        salir = true;
							        System.out.println("¡Que empiece la batalla!");
							        break;
							    default:
							        System.out.println("Opcion no valida");
							}
					
