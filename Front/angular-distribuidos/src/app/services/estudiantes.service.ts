import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EstudiantesService {
  private apiUrl = '/api/estudiantes'; // Ajusta según tu backend

  constructor(private http: HttpClient) {}

  getEstudiantes(): Observable<[]> {
    console.log("llamando a la api");
    console.log(this.apiUrl);
    return this.http.get<[]>(this.apiUrl+"/listar");

  }

  crearEstudiante(estudiante: any): Observable<any> {
    return this.http.post(this.apiUrl+'/crear', estudiante);
  }

  actualizarEstudiante(estudiante: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${estudiante.id}`, estudiante);
  }

  eliminarEstudiante(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
  
}
