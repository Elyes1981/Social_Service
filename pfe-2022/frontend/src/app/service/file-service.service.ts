import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FileServiceService {

  private server = 'http://localhost:8978';

  constructor(private http: HttpClient) { }

  // define function to upload files
  upload(formData: FormData): Observable<HttpEvent<string[]>> {
    return this.http.post<string[]>(`${this.server}/file/upload/`, formData, {
      reportProgress: true,
      observe: 'events'
    });
  }
  get  url() {
    return `${this.server}/file/download/`
  }
  // define function to download files
  download(filename: string): Observable<HttpEvent<Blob>> {
    return this.http.get(`${this.server}/file/download/${filename}/`, {
      reportProgress: true,
      observe: 'events',
      responseType: 'blob'
    });
  }
  getPhoto(filename: string): Observable<HttpEvent<Blob>> {
    return this.http.get(`${this.server}/photo/${filename}/`, {
      reportProgress: true,
      observe: 'events',
      responseType: 'blob'
    });
  }
}
