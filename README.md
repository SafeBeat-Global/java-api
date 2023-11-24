SafeBeat é um sistema inovador de monitoramento de saúde. Ao adquirir a pulseira SafeBeat, os usuários podem cadastrar suas informações vitais e vincular a pulseira à sua conta. O sistema atende tanto a usuários independentes quanto a instituições como asilos, permitindo monitoramento remoto e notificações em caso de sinais de infarto.

Existem 4 tipos de usuários:
- Paciente: quem está sendo monitorado;
- Monitor: quem está monitorando o paciente;
  - Independente: um familiar, amigo etc.;
  - Funcionário: alguém atrelado a uma instituição, como um enfermeiro.
- Moderador: quem está responsável pela moderação das instituições e seus funcionários.

## Arquitetura

Diagrama geral:

![image](/imagens/diagrama_geral.png)

Diagrama do banco (simplificado devido ao prazo apertado):

![image](/imagens/diagrama_banco.png)

### DevOps tools e cloud computing

Decidimos usar o banco Oracle forncido pela FIAP.

### Capturas dos recursos Azure

Visão geral do grupo de recurso:

![image](https://github.com/SafeBeat-Global/api-java/assets/101985616/5842177e-10e7-447c-b677-8b9e72ca7d39)

Visão geral do Plano do Serviço de Aplicativos:

![image](https://github.com/SafeBeat-Global/api-java/assets/101985616/b58420d3-3438-4fc6-a51a-30b043df188d)

Visão geral do serviço de Aplicativo Web:

![image](https://github.com/SafeBeat-Global/api-java/assets/101985616/829228bd-2351-4f70-af3b-3956d3682f2e)

Tive alguns problemas com esse bendito banco da fiap:

![image](https://github.com/SafeBeat-Global/api-java/assets/101985616/10da9177-0f75-4d4f-bb13-852c932d982d)

## Requisições

Deixarei aqui apenas exemplos de usuário.

### **REGISTRAR**

POST `/usuario/registrar`

Exemplo de json

```json
{
  "nome": "adilson",
  "email": "adilson@gmail.com",
  "senha": "87654321",
  "telefone": "11974429874",
  "tipoUsuario": "comum"
}
```

Resposta:

```json
{
	"id": 1,
	"nome": "adilson",
	"email": "adilson@gmail.com",
	"senha": "$2a$10$wXHVTSLQxRKjmWR1bPqoT.jRJlXaELfO/igqHseb7N7QIzVhdeE0i",
	"telefone": "11974429874",
	"tipoUsuario": "comum",
	"enabled": true,
	"password": "$2a$10$wXHVTSLQxRKjmWR1bPqoT.jRJlXaELfO/igqHseb7N7QIzVhdeE0i",
	"authorities": [
		{
			"authority": "ROLE_USUARIO"
		}
	],
	"username": "adilson@gmail.com",
	"accountNonExpired": true,
	"credentialsNonExpired": true,
	"accountNonLocked": true
}
```

### **LOGIN**

POST `usuario/login`

Exemplo de requisição:

```json
{
  "email": "adilson@gmail.com",
  "senha": "87654321"
}
```

Respostas:

`Credenciais de login incorretas`

```json
{
	"token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZGlsc29uQGdtYWlsLmNvbSIsImlzcyI6Imdsb2JhbCIsImV4cCI6MTcwMDgwNTc3MH0.7O6Ci1Ez_QeGVWFeWX-PxQh4aX01qgoS-6hPhhdu_ms",
	"type": "JWT",
	"prefix": "Bearer"
}
```

### **LISTAR**

GET `/usuario`

Reposta:

```json
[
	{
		"id": 1,
		"nome": "adilson",
		"email": "adilson@gmail.com",
		"senha": "$2a$10$wXHVTSLQxRKjmWR1bPqoT.jRJlXaELfO/igqHseb7N7QIzVhdeE0i",
		"telefone": "11975537288",
		"tipoUsuario": "comum",
		"enabled": true,
		"password": "$2a$10$wXHVTSLQxRKjmWR1bPqoT.jRJlXaELfO/igqHseb7N7QIzVhdeE0i",
		"authorities": [
			{
				"authority": "ROLE_USUARIO"
			}
		],
		"username": "adilson@gmail.com",
		"accountNonExpired": true,
		"credentialsNonExpired": true,
		"accountNonLocked": true
	},
	{
		"id": 2,
		"nome": "fernando",
		"email": "fernando@gmail.com",
		"senha": "$2a$10$y8Oyokkmx4z3SRG.JeD9Aepm0Xn7PdEluNcaXJhEapBEN2uqwL/CW",
		"telefone": "11788324567",
		"tipoUsuario": "monitor",
		"enabled": true,
		"password": "$2a$10$y8Oyokkmx4z3SRG.JeD9Aepm0Xn7PdEluNcaXJhEapBEN2uqwL/CW",
		"authorities": [
			{
				"authority": "ROLE_USUARIO"
			}
		],
		"username": "fernando@gmail.com",
		"accountNonExpired": true,
		"credentialsNonExpired": true,
		"accountNonLocked": true
	}
]
```

### **LER**

GET `/usuario/{id}`

Reposta:

```json
{
	"id": 1,
	"nome": "adilson",
	"email": "adilson@gmail.com",
	"senha": "$2a$10$wXHVTSLQxRKjmWR1bPqoT.jRJlXaELfO/igqHseb7N7QIzVhdeE0i",
	"telefone": "11975537288",
	"tipoUsuario": "comum",
	"enabled": true,
	"password": "$2a$10$wXHVTSLQxRKjmWR1bPqoT.jRJlXaELfO/igqHseb7N7QIzVhdeE0i",
	"authorities": [
		{
			"authority": "ROLE_USUARIO"
		}
	],
	"username": "adilson@gmail.com",
	"accountNonExpired": true,
	"credentialsNonExpired": true,
	"accountNonLocked": true
}
```

### **DELETAR**

DELETE `/usuario/{id}`

Resposta: OK

### **EDITAR**

PUT `/usuario/{id}`

Exemplo de requisição:
/usuario/2
```json
{
  "nome": "adilson",
  "email": "adilson@gmail.com",
  "senha": "87654321",
  "telefone": "11788324567",
  "tipoUsuario": "monitor"
}
```

Resposta:

```json
{
	"id": 2,
	"nome": "adilson",
	"email": "adilson@gmail.com",
	"senha": "87654321",
	"telefone": "11788324567",
	"tipoUsuario": "monitor",
	"enabled": true,
	"password": "87654321",
	"authorities": [
		{
			"authority": "ROLE_USUARIO"
		}
	],
	"username": "adilson@gmail.com",
	"accountNonExpired": true,
	"credentialsNonExpired": true,
	"accountNonLocked": true
}
```



