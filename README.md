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

*User Login

```http
  POST /login
```

#### Example
```
Authorization: No authentication required
Content-Type: application/json

{
    "nombreUsuario" : "MedicoUser",
    "contrasenia" : "123456789"
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
This endpoint PUT /api/v1/patients is used to update the information of an existing patient in the database. When a user registers, corresponding entries are created in the database for the patient, so this endpoint only requires updating existing values rather than creating new records.

Authorization and User Type
To access this endpoint, the user must be authenticated and have the role of "PACIENTE".

```http
  PUT /api/v1/pacientes
```

#### Example
```
Authorization: Bearer <token>
Content-Type: application/json

{
 "nombre": "New First Name",
 "apellido": "New Last Name",
 "fechaNacimiento": "yyyy-mm-dd",
 "genero": "New Gender",
 "numeroTelefono": "New Phone Number"
}
```

### Doctor Endpoints
*Get Doctor a list of Doctors

```http
  GET /api/v1/medicos/
```
Retrieves a list of all doctors along with their specialization and address information.

*Get Doctor by ID

```http
  GET /api/v1/medicos/{id}
```
Retrieves information about a Doctor by their ID.

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `integer` |  **Required** Doctor's ID. |

* Update Doctor Information
This endpoint PUT /api/v1/medicos is used to update the profile information of an existing doctor in the database. When a user registers, corresponding entries are created in the database for the doctor, so this endpoint only requires updating existing values rather than creating new records.

Authorization and User Type
To access this endpoint, the user must be authenticated and have the role of "MEDICO".

```http
  PUT /api/v1/medicos
```
### Example
```
Authorization: Bearer <token>
Content-Type: application/json

{
 "nombre": "example_name",
 "documento": "example_document",
 "especialidad": ""
}

```
### Direction Endpoints

* Update Address Information

This endpoint is used to update the address information of the authenticated user. Users with the roles "MEDICO" and "PACIENTE" can access this endpoint to update their address details.

```http
  PUT /api/v1/direccion
```

### Example
```
Authorization: Bearer <token>
Content-Type: application/json

{
  "calle": "Main Street",
  "numero": "123",
  "ciudad": "Cityville",
  "distrito": "District X",
  "complemento": "Apartment 101"
}
```
