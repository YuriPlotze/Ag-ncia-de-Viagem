## API para Agência de Viagens

### Endpoints Disponíveis
1. **Cadastrar Destino**
   - Método: `POST /api/destinos`
   - Exemplo de Body (JSON):
     ```json
     {
       "nome": "SC",
       "localizacao": "Brasil",
       "descricao": "Viagem para Florianopolis",
       "precoPacote": 4000.0
     }
     ```

2. **Listar Destinos (Geral)**
   - Método: `GET /api/destinos`

3. **Visualizar Destino (Único)**
   - Método: `GET /api/destinos/{id}`

4. **Pesquisar Destinos**
   - Método: `GET /api/destinos/search?termo=Rio`

5. **Reservar Pacote**
   - Método: `POST /api/destinos/{id}/reservar`

6. **Deletar Destino**
   - Método: `DELETE /api/destinos/{id}`

7. **Adicionar nota**
   - Método:  `PATCH /api/destinos/{id}/avaliar`
   - Exemplo de Body (JSON):
      ```json  
      {
         "nota": 9
      }
      ```