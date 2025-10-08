export class Patient 
{
    patientId:number;
    fullName:string;
    dateOfBirth:Date;
    contactNumber:string;
    email:string;
    address:string;
    
    constructor(patientId:number, fullName:string, dateOfBirth:Date,contactNumber:string, email:string, address:string)
    {
        this.patientId=patientId;
        this.fullName=fullName;
        this.dateOfBirth=dateOfBirth;
        this.contactNumber=contactNumber;
        this.email=email;
        this.address=address;
    }
    
    logAttributes()
    {
        console.log('Patient Details');
        console.log('Patient ID:' + this.patientId);
        console.log('Full Name:' + this.fullName);
        console.log('Date Of Birth:' + (this.dateOfBirth instanceof Date ? this.dateOfBirth.toISOString().split('T')[0] : this.dateOfBirth));
        console.log('Contact Number:' + this.contactNumber);
        console.log('Email:' + this.email);
        console.log('Address:' + this.address);
    }
}