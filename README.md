
# Medicalia v1

This is a Spring Framework project where you can create users of type Doctor and Patient. Each patient can have multiple assigned doctors and can view their address and specialty, while the doctor can only access important patient data.

## Dependencies
The following dependencies were used in this project:
* Lombok 
* JWT 
* Devtools
* MySql y JPA
* Spring Security
* MapStruct
* Spring Web

## Installation 

Clone this repository. This project uses Spring Boot 3.2.2 with Java 17.
```
  git clone https://github.com/LeoMtos/Spring-Medicalia
```
## Uso de API

### User Endpoints
* Registers a new user with a specified role.
```http
  POST /api/v1/users/{role}
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `role` | `string` |  **Required** Role of the user (MEDICO o PACIENTE). |

#### Example
```
{
 "nombreUsuario": "example_user",
 "contrasenia": "example_password",
 "email": "example@example.com"
}
```

### Patient Endpoints

* Get Patient by ID
```http
  POST /api/v1/pacientes/{id}
```
Retrieves information about a patient by their ID.

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `integer` |  **Required** Patient's ID. |

* Update Patient Information

```http
  PUT /api/v1/pacientes
```

#### Example
```
{
 "nombre": "New First Name",
 "apellido": "New Last Name",
 "fechaNacimiento": "yyyy-mm-dd",
 "genero": "New Gender",
 "numeroTelefono": "New Phone Number"
}
```
