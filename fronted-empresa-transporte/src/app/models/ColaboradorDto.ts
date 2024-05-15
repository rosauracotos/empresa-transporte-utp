export class ColaboradorDto {
  estadoempleado: string;
  numdocumento: string;
  colaboradorid: number;
  cargo: string;
  persona: string;
  grupolaboral: string;

  constructor(data:any) {
    this.estadoempleado = data.estadoempleado;
    this.numdocumento = data.numdocumento;
    this.colaboradorid = data.colaboradorid;
    this.cargo = data.cargo;
    this.persona = data.persona;
    this.grupolaboral = data.grupolaboral;
  }
}
