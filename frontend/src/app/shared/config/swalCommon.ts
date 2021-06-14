import { SweetAlertOptions } from 'sweetalert2';

export const swalDesition = (title: string): SweetAlertOptions => ({
    title,
    type: 'question',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Confirmar',
    cancelButtonText: 'Cancelar'
});

export const swalSelected = (title: string, text: string, options: any): SweetAlertOptions => ({
    title,
    text,
    type: 'question',
    input: 'select',
    inputValue: '0',
    inputOptions: options,
    inputPlaceholder: text,
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Confirmar',
    cancelButtonText: 'Cancelar'
});

export const swalSuccessMessage = (title: string): SweetAlertOptions => ({
    title,
    type: 'success',
    showConfirmButton: false,
    timer: 2000
});

export const swalSuccessMesText = (title: string, text: string): SweetAlertOptions => ({
    title,
    text,
    type: 'success',
    showConfirmButton: false,
    timer: 3000
});


export const swalInfo = (title: string): SweetAlertOptions => ({
    title,
    type: 'info',
    showConfirmButton: false,
    timer: 3000
});

export const swalWarning = (title: string): SweetAlertOptions => ({
    title,
    showConfirmButton: false,
    type: 'warning',
    timer: 2000
});

export const swalWarningUser = (title: string): SweetAlertOptions => ({
    title,
    showConfirmButton: false,
    type: 'warning',
    timer: 300000
});

export const swalErrorMesage = (title: string, text: string): SweetAlertOptions => ({
    title,
    text,
    showConfirmButton: false,
    type: 'error',
    timer: 3000
});

export const swalError = (title: string): SweetAlertOptions => ({
    title,
    showConfirmButton: false,
    type: 'error',
    timer: 3000
});

export const swalErrorConfirm = (title: string): SweetAlertOptions => ({
    title,
    showConfirmButton: true,
    type: 'error'
});

