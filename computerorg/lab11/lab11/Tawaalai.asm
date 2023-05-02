.386
.model flat, stdcall
.stack 4096
ExitProcess proto, dwExitCode:dword

.data
var1 sdword 100
var2 sdword 200
var3 sdword 50
var4 sdword ?
.code
main proc
	mov eax, var1
	imul var2
	mov var1, eax
	mov eax, var3
	mov ebx, 5
	imul ebx
	mov var3, eax
	mov eax, var1
	idiv var3
	mov var4, eax
	INVOKE ExitProcess,0
main ENDP
END main


