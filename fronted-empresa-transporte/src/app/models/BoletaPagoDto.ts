export class BoletaPagoDto {
  year: number;
  month: number;
  monthName: string;
  lastModified: Date;

  constructor(data:any) {
    this.year = data.year;
    this.month = data.month;
    this.monthName = data.monthName;
    this.lastModified = data.lastModified;
  }

}
