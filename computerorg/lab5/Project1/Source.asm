.386
.model flat,stdcall
.stack 4096

ExitProcess PROTO,dwExitCode:DWORD
.data
	Xval dword 26
	Yval dword 30
	Zval dword 40
	myWord word 4 dup(1,2,3,4,5)

.code
main PROC
	mov eax, 0
	mov ax,myWord+0
	add ax, myWord+2
	add ax, myWord+4
	add ax, myWord+6
	add ax, myWord+8
	
	INVOKE ExitProcess,0
main ENDP
END main