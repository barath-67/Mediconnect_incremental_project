export class Doctor 
{
    doctorId:number;
    fullName:string;
    contactNumber:string;
    email:string;
    specialty:string;
    yearsOfExperience:number;

    constructor(doctorId:number,fullName:string, contactNumber:string,email:string,specialty:string, yearsOfExperience:number)
    {
        this.doctorId=doctorId;
        this.fullName=fullName;
        this.contactNumber=contactNumber;
        this.email=email;
        this.specialty=specialty;
        this.yearsOfExperience=yearsOfExperience;
    }
    logAttributes()
    {
        console.log('Doctor Details');
        console.log('Doctor ID:' + this.doctorId);
        console.log('Full Name:' + this.fullName);
        console.log('Specialty:' + this.specialty);
        console.log('Contact Number:' + this.contactNumber);
        console.log('Email:' + this.email);
        console.log('Years Of Experience:' + this.yearsOfExperience);
    }
}